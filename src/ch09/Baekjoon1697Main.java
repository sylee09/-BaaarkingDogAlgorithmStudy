package ch09;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon1697Main {
    static boolean[] check = new boolean[100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int subin = Integer.parseInt(s[0]);
        int sister = Integer.parseInt(s[1]);

        char[] direction = {'g', 'b', 'd'};

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(subin);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int cur = deque.poll();
                check[cur] = true;
                if (cur == sister) {
                    System.out.println(level);
                    return;
                }
                for (int k = 0; k < 3; k++) {
                    int nc;
                    switch (direction[k]){
                        case 'g':
                            nc = cur + 1;
                            break;
                        case 'b':
                            nc = cur - 1;
                            break;
                        case 'd':
                            nc = cur * 2;
                            break;
                        default:
                            continue;
                    }
                    if (nc >= 0 && nc <= 100000) {
                        if (!check[nc]) {
                            deque.add(nc);
                        }
                    }
                }
            }
            level++;
        }
    }
}

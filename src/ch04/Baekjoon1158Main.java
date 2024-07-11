package ch04;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon1158Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);

        for (int i = 1; i <= n1; i++) {
            deque.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");

        int cnt = 1;
        while (!deque.isEmpty()) {
            cnt = cnt % n2;
            if (cnt == 0) {
                stringBuilder.append(deque.poll() + ", ");
            } else {
                deque.add(deque.poll());
            }
            cnt++;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(">");
        System.out.println(stringBuilder);
    }
}

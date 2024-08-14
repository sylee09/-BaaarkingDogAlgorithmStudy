package ch09;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon7569Main {
    static boolean[][][] visited;
    static int level = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);

        int[][][] box = new int[n][m][h];
        visited = new boolean[n][m][h];
        LinkedList<Coordinates7569> maturedTomatoes = new LinkedList<>();

        for (int h1 = 0; h1 < h; h1++) {
            for (int n1 = 0; n1 < n; n1++) {
                s = scanner.nextLine().split(" ");
                for (int m1 = 0; m1 < m; m1++) {
                    box[n1][m1][h1] = Integer.parseInt(s[m1]);
                    if (box[n1][m1][h1] == 1) {
                        maturedTomatoes.add(new Coordinates7569(n1, m1, h1));
                    }
                }
            }
        }

        bfs(box, maturedTomatoes, m, n, h);

        for (int h1 = 0; h1 < h; h1++) {
            for (int n1 = 0; n1 < n; n1++) {
                for (int m1 = 0; m1 < m; m1++) {
                    if (box[n1][m1][h1] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(level-1);

    }

    static void bfs(int[][][] box, LinkedList<Coordinates7569> maturedTomatoes, int m, int n, int h) {
        char[] direction = {'u', 'd', 'l', 'r', 'f', 'b'};

        ArrayDeque<Coordinates7569> deque = new ArrayDeque<>();
        while (!maturedTomatoes.isEmpty()) {
            deque.add(maturedTomatoes.poll());
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Coordinates7569 coord = deque.poll();
                int cm = coord.m;
                int cn = coord.n;
                int ch = coord.h;
                for (int k = 0; k < 6; k++) {
                    int nm = cm;
                    int nn = cn;
                    int nh = ch;
                    switch (direction[k]) {
                        case 'u':
                            nh += 1;
                            break;
                        case 'd':
                            nh -= 1;
                            break;
                        case 'l':
                            nm -= 1;
                            break;
                        case 'r':
                            nm += 1;
                            break;
                        case 'f':
                            nn -= 1;
                            break;
                        case 'b':
                            nn += 1;
                            break;
                    }
                    if (nh >= 0 && nh < h
                            && nm >= 0 && nm < m
                            && nn >= 0 && nn < n) {
                        if (!visited[nn][nm][nh]&&box[nn][nm][nh]==0) {
                            box[nn][nm][nh] = 1;
                            visited[nn][nm][nh] = true;
                            deque.add(new Coordinates7569(nn, nm, nh));
                        }
                    }
                }
            }
            level++;
        }
    }
}
class Coordinates7569{
    int m;
    int n;
    int h;

    public Coordinates7569(int n, int m, int h) {
        this.m = m;
        this.n = n;
        this.h = h;
    }
}
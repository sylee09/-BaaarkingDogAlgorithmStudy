package ch11;

import java.util.Scanner;

public class Baekjoon2447 {
    static char[][] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        answer = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = ' ';
            }
        }

        func(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    static void func(int startR, int startC, int size) {
        if (size == 1) {
            answer[startR][startC] = '*';
        } else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    func(startR + newSize * i, startC + newSize * j, newSize);
                }
            }
        }
    }
}

package ch11;

import java.util.Scanner;

public class Baekjoon2448 {
    static char[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        answer = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                answer[i][j] = ' ';
            }
        }
        func(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void func(int startR, int startC, int size) {
        if (size == 3) {
            answer[startR][startC] = '*';
            answer[startR + 1][startC + 1] = '*';
            answer[startR + 1][startC - 1] = '*';
            answer[startR + 2][startC] = '*';
            answer[startR + 2][startC + 1] = '*';
            answer[startR + 2][startC - 1] = '*';
            answer[startR + 2][startC + 2] = '*';
            answer[startR + 2][startC - 2] = '*';
        } else {
            int newSize = size / 2;
            func(startR, startC, newSize);
            func(startR + newSize, startC - newSize, newSize);
            func(startR + newSize, startC + newSize, newSize);
        }
    }
}

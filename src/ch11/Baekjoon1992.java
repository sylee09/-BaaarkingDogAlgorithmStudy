package ch11;

import java.util.Scanner;

public class Baekjoon1992 {
    static int[][] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringBuilder str;
            str = new StringBuilder(sc.nextLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        func(0, 0, n);
        System.out.println(stringBuilder.toString());
    }

    static void func(int startR, int startC, int size) {
        if (checkAllSame(startR, startC, size)) {
            if (arr[startR][startC] == 0) {
                stringBuilder.append(0);
            } else {
                stringBuilder.append(1);
            }
        } else {
            int newSize = size / 2;
            stringBuilder.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    func(startR + i * newSize, startC + j * newSize, newSize);
                }
            }
            stringBuilder.append(")");
        }
    }

    static boolean checkAllSame(int startR, int startC, int size) {
        int first = arr[startR][startC];
        for (int i = startR; i < startR + size; i++) {
            for (int j = startC; j < startC + size; j++) {
                if (first != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

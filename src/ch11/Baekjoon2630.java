package ch11;

import java.util.Scanner;

public class Baekjoon2630 {
    static int arr[][];
    static int blue;
    static int white;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        func(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void func(int startR, int startC, int size) {
        if (checkAllcolorSame(startR, startC, size)) {
            if (arr[startR][startC] == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            int newSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    func(startR + newSize * i, startC + newSize * j, newSize);
                }
            }
        }
    }

    static boolean checkAllcolorSame(int startR, int startC, int size) {
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

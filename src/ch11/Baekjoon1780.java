package ch11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon1780 {
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;
    static int[][] arr;

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

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void func(int rStart, int cStart, int size) {
        if (allSameCheckFunction(rStart, cStart, size)) {
            if (arr[rStart][cStart] == -1) {
                minusOne++;
            }
            if (arr[rStart][cStart] == 0) {
                zero++;
            }
            if (arr[rStart][cStart] == 1) {
                one++;
            }
        } else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(rStart + newSize * i, cStart + newSize * j, newSize);
                }
            }
        }
    }

    static boolean allSameCheckFunction(int rStart, int cStart, int size) {
        int firstValue = arr[rStart][cStart];
        for (int i = rStart; i < rStart + size; i++) {
            for (int j = cStart; j < cStart + size; j++) {
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}

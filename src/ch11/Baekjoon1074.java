package ch11;

import java.util.Scanner;

public class Baekjoon1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(functionz(n, r, c));
    }
    static int functionz(int n, int r, int c) {
        if (n == 1) {
            if (r == 0 && c == 0) {
                return 0;
            }
            if (r == 0 && c == 1) {
                return 1;
            }
            if (r == 1 && c == 0) {
                return 2;
            }
            if (r == 1 && c == 1) {
                return 3;
            }
        }
        int half = 1 << (n - 1);
        int areaSize = 1 << (2 * n - 2);

        if (r < half) {
            if (c < half) {
                return functionz(n - 1, r % half, c % half);
            } else {
                return areaSize + functionz(n - 1, r % half, c % half);
            }

        } else {
            if (c < half) {
                return areaSize * 2 + functionz(n - 1, r % half, c % half);
            } else {
                return areaSize * 3 + functionz(n - 1, r % half, c % half);
            }

        }
    }
}

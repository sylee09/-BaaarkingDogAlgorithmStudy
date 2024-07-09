package ch02;

import java.util.Scanner;

public class Baekjoon2576Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = 0;
        int min = Integer.MAX_VALUE;
        boolean presentOdd = false;
        for (int i = 0; i < 7; i++) {
            int n = scanner.nextInt();
            if (n % 2 != 0) {
                s += n;
                presentOdd = true;
                min = Math.min(min, n);
            }
        }
        if (presentOdd) {
            System.out.println(s);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}

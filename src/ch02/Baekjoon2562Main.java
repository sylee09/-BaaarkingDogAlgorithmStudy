package ch02;

import java.util.Scanner;

public class Baekjoon2562Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            int n = scanner.nextInt();
            if (max < n) {
                max = n;
                maxIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx+1);
    }
}

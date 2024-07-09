package ch02;

import java.util.Scanner;

public class Baekjoon2444Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= (n - i); space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            for (int space = 1; space <= i-1; space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * (n-i+1)) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

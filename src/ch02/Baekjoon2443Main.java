package ch02;

import java.util.Scanner;

public class Baekjoon2443Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= i - 1; space++) {
                System.out.print(" ");
            }
            for (int j = 2 * (n-i+1) - 1; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

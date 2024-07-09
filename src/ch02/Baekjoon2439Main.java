package ch02;

import java.util.Scanner;

public class Baekjoon2439Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = n;
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space < a; space++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            a--;
        }
    }
}

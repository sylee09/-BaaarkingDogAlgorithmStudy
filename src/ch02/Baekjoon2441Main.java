package ch02;

import java.util.Scanner;

public class Baekjoon2441Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int a = i - 1;
            for (int space = 1; space <= a; space++) {
                System.out.print(" ");
            }
            for (int j = n-i+1; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

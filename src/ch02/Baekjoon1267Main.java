package ch02;

import java.util.Scanner;

public class Baekjoon1267Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int y = 0;
        int m = 0;
        for (int element : arr) {
            y += (10 + 10 * (element / 30));
            m += (15 + 15 * (element / 60));
        }
        if (y == m) {
            System.out.println("Y M " + y);
        } else if (y > m) {
            System.out.println("M " + m);
        } else {
            System.out.println("Y " + y);
        }
    }
}

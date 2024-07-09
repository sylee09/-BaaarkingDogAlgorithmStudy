package ch02;

import java.util.Scanner;

public class Baekjoon10093Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long temp1 = Math.max(a, b);
        long temp2 = Math.min(a, b);
        a = temp2;
        b = temp1;
        if (a == b) {
            System.out.println(0);
        } else {
            System.out.println(b - a - 1);
            for (long i = a + 1; i < b; i++) {
                System.out.print(i+" ");
            }
        }
    }
}

package ch02;

import java.util.Scanner;

public class Baekjoon10804Main {
    public static void main(String[] args) {
        int[] arr = new int[21];
        for (int i = 0; i <= 20; i++) {
            arr[i] = i;
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            func(arr, a, b);
        }
        for (int i=1;i<=20;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void func(int[] arr, int a, int b) {
        int x = b;
        for (int i = a; i <= (a+b)/2; i++) {
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
            x--;
        }
    }
}

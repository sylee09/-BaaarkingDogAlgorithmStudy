package ch02;

import java.util.Scanner;
import java.util.Arrays;

public class Baekjoon2587Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}

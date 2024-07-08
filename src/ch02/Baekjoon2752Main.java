package ch02;

import java.util.Scanner;
import java.util.Arrays;

public class Baekjoon2752Main {
    public static void main(String[] args) {
        int[] arr = new int[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int element : arr) {
            System.out.print(element+" ");
        }
    }
}

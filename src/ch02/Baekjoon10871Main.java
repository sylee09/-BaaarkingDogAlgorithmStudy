package ch02;

import java.util.Scanner;

public class Baekjoon10871Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        func(arr,x);
    }

    static void func(int[] arr, int x) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int element:arr){
            if (element < x) {
                stringBuilder.append(element+" ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}

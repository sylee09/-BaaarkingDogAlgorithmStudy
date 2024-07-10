package ch03;

import java.util.Scanner;

public class Baekjoon1475Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int[] arr = new int[10];
        for (char ch : number.toCharArray()) {
            if (ch == '9' || ch == '6') {
                if (arr[6] > arr[9]) {
                    arr[9] += 1;
                } else {
                    arr[6] += 1;
                }
            } else {
                arr[Integer.parseInt(String.valueOf(ch))] += 1;
            }
        }
        int answer = 0;
        for (int element : arr) {
            if (element > answer) {
                answer = element;
            }
        }
        System.out.println(answer);

    }
}

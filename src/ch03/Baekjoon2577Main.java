package ch03;

import java.util.Scanner;

public class Baekjoon2577Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int res = a * b * c;
        String resToString = String.valueOf(res);
        char[] ans = new char[10];
        for (char ch : resToString.toCharArray()) {
            int chToInt = Integer.parseInt(String.valueOf(ch));
            ans[chToInt] += 1;
        }
        for (int element : ans) {
            System.out.println(element);
        }
    }
}

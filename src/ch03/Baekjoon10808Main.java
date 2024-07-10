package ch03;

import java.util.Scanner;

public class Baekjoon10808Main {
    public static void main(String[] args) {
        int[] alphabet = new int[26];
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (char ch : str.toCharArray()) {
            alphabet[(int) ch - 97] += 1;
        }
        for (int element : alphabet) {
            System.out.print(element+" ");
        }
    }
}

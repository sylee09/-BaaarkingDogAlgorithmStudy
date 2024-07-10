package ch03;

import java.util.Scanner;

public class Baekjoon13300Main {
    public static void main(String[] args) {
        int[] girls = new int[7];
        int[] boys = new int[7];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sex = scanner.nextInt();
            int grade = scanner.nextInt();
            if (sex == 0) {
                girls[grade] += 1;
            } else {
                boys[grade] += 1;
            }
        }
        int ans = 0;
        for(int element:girls){
            ans += element / k;
            if (element % k != 0) {
                ans += 1;
            }
        }
        for (int element : boys) {
            ans += element / k;
            if (element % k != 0) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

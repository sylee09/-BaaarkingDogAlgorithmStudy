package ch11;

import java.util.Scanner;

public class Baekjoon11729 {
    static int cnt = 0;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        hanoi(k, 1, 3);
        System.out.println(cnt);
        System.out.println(stringBuilder.toString());
    }
    static void hanoi(int k, int current, int goal) {
        if (k == 1) {
            stringBuilder.append(current + " " + goal+"\n");
            cnt++;
        } else {
            hanoi(k - 1, current, 6-current-goal);
            stringBuilder.append(current + " " + goal + "\n");
            cnt++;
            hanoi(k - 1, 6-current-goal, goal);
        }
    }
}

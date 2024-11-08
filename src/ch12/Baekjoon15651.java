package ch12;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        dfs(n, m, 0, list, answer);
        System.out.println(answer);
    }

    static void dfs(int n, int m, int level, LinkedList<Integer> list, StringBuilder stringBuilder) {
        if (level == m) {
            for (int element : list) {
                stringBuilder.append(element + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                list.add(i);
                dfs(n, m, level + 1, list, stringBuilder);
                list.pollLast();
            }
        }
    }
}

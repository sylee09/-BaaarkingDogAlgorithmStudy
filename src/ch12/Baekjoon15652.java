package ch12;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15652 {
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dfs(n, m, 0, 1, new LinkedList<Integer>());
        System.out.println(stringBuilder.toString());
    }

    static void dfs(int n, int m, int level, int start, LinkedList<Integer> list) {
        if (level == m) {
            for (int element : list) {
                stringBuilder.append(element + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                dfs(n, m, level + 1, i, list);
                list.pollLast();
            }
        }
    }
}

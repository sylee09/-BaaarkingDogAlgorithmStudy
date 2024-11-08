package ch12;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        dfs(1, n, m, 0, list);
    }
    static void dfs(int cur, int n, int m, int level, LinkedList<Integer> list) {
        if (level == m) {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        } else {
            for (int i = cur; i <= n; i++) {
                list.add(i);
                dfs(i + 1, n, m, level + 1, list);
                list.pollLast();
            }
        }
    }
}

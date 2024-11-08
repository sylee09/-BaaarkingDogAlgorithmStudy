package ch12;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15649 {
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        check = new boolean[n+1];
        LinkedList<Integer> list = new LinkedList<>();
        dfs(n, m, 0, list);
    }

    static void dfs(int n, int m, int level, LinkedList<Integer> list) {
        if (level == m) {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    list.add(i);
                    dfs(n, m, level + 1, list);
                    list.pollLast();
                    check[i] = false;
                }
            }
        }
    }

}

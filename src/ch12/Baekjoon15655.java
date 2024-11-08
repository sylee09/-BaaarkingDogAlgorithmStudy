package ch12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15655 {
    static boolean[] check;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0, m, new LinkedList<Integer>(), 0);
        System.out.println(stringBuilder.toString());
    }

    static void dfs(int level, int m, LinkedList<Integer> list, int startIndex) {
        if (level == m) {
            for (int element : list) {
                stringBuilder.append(element + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int i = startIndex; i < arr.length; i++) {
                if (!check[i]) {
                    list.add(arr[i]);
                    check[i] = true;
                    dfs(level + 1, m, list, i);
                    check[i] = false;
                    list.pollLast();
                }
            }
        }
    }
}

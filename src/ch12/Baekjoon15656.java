package ch12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15656 {
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0, m, new LinkedList<Integer>());
        System.out.println(stringBuilder.toString());
    }

    static void dfs(int level, int m, LinkedList<Integer> list) {
        if (level == m) {
            for (int element : list) {
                stringBuilder.append(element + " ");
            }
            stringBuilder.append("\n");
        } else {
            for (int element : arr) {
                list.add(element);
                dfs(level + 1, m, list);
                list.pollLast();
            }
        }
    }
}

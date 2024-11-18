package ch12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15665 {
    static HashSet<String> set = new HashSet<>();
    static int[] arr;
    static StringBuilder builder = new StringBuilder();

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
        System.out.println(builder);
    }

    static void dfs(int level, int m, LinkedList<Integer> list) {
        if (level == m) {
            if (!set.contains(list.toString())) {
                set.add(list.toString());
                for (Integer s : list) {
                    builder.append(s + " ");
                }
                builder.append("\n");
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
                dfs(level + 1, m, list);
                list.pollLast();
            }
        }
    }
}

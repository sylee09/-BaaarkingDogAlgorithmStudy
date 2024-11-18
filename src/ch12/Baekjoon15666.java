package ch12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15666 {
    static int[] arr;
    static HashSet<String> set = new HashSet<>();
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
        System.out.println(builder.toString());
    }
    static void dfs(int level, int m, LinkedList<Integer> list) {
        if (level == m) {
            if (!set.contains(list.toString())) {
                set.add(list.toString());
                for (int element : list) {
                    builder.append(element + " ");
                }
                builder.append("\n");
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (list.isEmpty()) {
                    list.add(arr[i]);
                    dfs(level + 1, m, list);
                    list.pollLast();
                } else {
                    int top = list.getLast();
                    if (top <= arr[i]) {
                        list.add(arr[i]);
                        dfs(level + 1, m, list);
                        list.pollLast();
                    }
                }
            }
        }
    }
}

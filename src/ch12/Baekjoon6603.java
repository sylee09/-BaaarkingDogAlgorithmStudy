package ch12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon6603 {
    static int[] arr;
    static boolean[] check;
    static StringBuilder builder;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            builder = new StringBuilder();
            int k = sc.nextInt();
            if (k == 0) {
                break;
            }
            arr = new int[k];
            check = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            dfs(0, 6, new LinkedList<Integer>());
            System.out.println(builder.toString());
        }
    }
    static void dfs(int level, int limit, LinkedList<Integer> list) {
        if (level == limit) {
            if (!set.contains(list.toString())) {
                set.add(list.toString());
                for (int element : list) {
                    builder.append(element + " ");
                }
                builder.append("\n");
            }
        }else{
            for (int i = level; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    if (list.isEmpty()) {
                        list.add(arr[i]);
                        dfs(level + 1, limit, list);
                        list.pollLast();
                    } else {
                        int element = list.getLast();
                        if (element < arr[i]) {
                            list.add(arr[i]);
                            dfs(level + 1, limit, list);
                            list.pollLast();
                        }
                    }
                    check[i] = false;
                }
            }
        }
    }
}

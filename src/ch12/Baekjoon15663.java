package ch12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon15663 {
    static int[] arr;
    static HashSet<String> set = new HashSet<>();
    static boolean[] check;

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

        dfs(0, m, new LinkedList<>());
    }

    static void dfs(int level, int m, LinkedList<Integer> list) {
        if (level == m) {
            if (!set.contains(list.toString())) {
                set.add(list.toString());
                for (int element : list) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    list.add(arr[i]);
                    dfs(level + 1, m, list);
                    list.pollLast();
                    check[i] = false;
                }

            }
        }
    }
}

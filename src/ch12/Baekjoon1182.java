package ch12;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon1182 {
    static int answer = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();

        dfs(0, n, s, list);
        System.out.println(answer);
    }

    static void dfs(int cur, int n, int s, LinkedList<Integer> list) {
        int sum = 0;
        for (int element : list) {
            sum += element;
        }
        if (sum == s && !list.isEmpty()) {
            answer++;
        }
        for (int i = cur; i < n; i++) {
            list.add(arr[i]);
            dfs(i + 1, n, s, list);
            list.pollLast();
        }
    }
}

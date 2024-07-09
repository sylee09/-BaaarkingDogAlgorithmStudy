package ch02;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class Baekjoon2309Main {
    static boolean[] check = new boolean[9];
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }
        LinkedList<Integer> answer = new LinkedList<>();
        dfs(arr, 0, 0, answer, 0);
    }

    static void dfs(int[] arr, int level, int startIndex, LinkedList<Integer> answer, int sum) {
        if (flag) {
            return;
        }
        if (sum > 100) {
            return;
        }
        if (level >= 7 && sum==100) {
            Collections.sort(answer);
            for (int element : answer) {
                System.out.println(element);
            }
            flag = true;
        } else {
            for (int i = startIndex; i < arr.length; i++) {
                if (!check[i]) {
                    sum += arr[i];
                    answer.add(arr[i]);
                    check[i] = true;
                    dfs(arr, level + 1, i + 1, answer, sum);
                    sum -= arr[i];
                    answer.remove(answer.indexOf(arr[i]));
                    check[i] = false;
                }
            }
        }
    }
}

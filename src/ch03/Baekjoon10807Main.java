package ch03;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon10807Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int target = scanner.nextInt();
        if (!hashMap.containsKey(target)) {
            System.out.println(0);
        } else {
            System.out.println(hashMap.get(target));
        }

    }
}

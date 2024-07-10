package ch03;

import java.util.Scanner;
import java.util.HashSet;

public class Baekjoon3273Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            set.add(arr[i]);
        }
        long target = scanner.nextLong();
        int ans = 0;
        for (long element : arr) {
            if (set.contains(target - element)) {
                if (!(target-element == element)) {
                    ans++;
                    set.remove(element);
                }
            }
        }
        System.out.println(ans);
    }
}

package ch03;

import java.util.Scanner;
import java.util.HashMap;

public class Baekjoon1919Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;

        for (HashMap.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                ans += entry.getValue();
            } else {
                if (entry.getValue() != map2.get(entry.getKey())) {
                    ans += Math.abs(entry.getValue() - map2.get(entry.getKey()));
                }
            }
        }

        for (HashMap.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey())) {
                ans += entry.getValue();
            }
        }
        System.out.println(ans);

    }
}

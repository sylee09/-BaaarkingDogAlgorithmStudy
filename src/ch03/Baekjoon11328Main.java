package ch03;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon11328Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(func(str1, str2));
        }
    }
    static String func(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        for (HashMap.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                if (entry.getValue() != map2.get(entry.getKey())) {
                    return "Impossible";
                }
            } else {
                return "Impossible";
            }
        }
        return "Possible";
    }
}

package ch02;

import java.util.Scanner;
import java.util.HashMap;

public class Baekjoon2480Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int prize = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            int x = scanner.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value==2){
                prize = 1000 + (key) * 100;
            } else if (value == 3) {
                prize = 10000 + (key) * 1000;
            }
            max = Math.max(key, max);
        }
        if (prize != 0) {
            System.out.println(prize);
        } else {
            System.out.println(max*100);
        }

    }
}

package ch12;

import java.util.Scanner;

public class Baekjoon16987 {
    static Egg[] eggs;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }
        func(0);
        System.out.println(answer);
    }

    static void func(int level) {
        if (level == eggs.length) {
            countBrokenEgg();
            return;
        }
        Egg egg1 = eggs[level];
        if (egg1.durability <= 0) {
            func(level + 1);
        } else {
            boolean allBroken = true;
            for (int i = 0; i < eggs.length; i++) {
                if (eggs[i].durability <= 0 || i == level) {
                    continue;
                }else{
                    allBroken = false;
                    Egg egg2 = eggs[i];
                    collision(egg1, egg2);
                    func(level + 1);
                    restore(egg1, egg2);
                }
            }
            if (allBroken) {
                func(level + 1);
            }
        }
    }

    static void countBrokenEgg() {
        int ans = 0;
        for (Egg element : eggs) {
            if (element.durability <= 0) {
                ans++;
            }
        }
        if (ans > answer) {
            answer = ans;
        }
    }
    static void restore(Egg egg1, Egg egg2) {
        egg1.durability = egg1.durability + egg2.weight;
        egg2.durability = egg2.durability + egg1.weight;
    }
    static void collision(Egg egg1, Egg egg2) {
        egg1.durability = egg1.durability - egg2.weight;
        egg2.durability = egg2.durability - egg1.weight;
    }
    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}

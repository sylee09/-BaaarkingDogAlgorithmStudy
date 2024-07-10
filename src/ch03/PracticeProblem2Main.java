package ch03;

import java.util.HashMap;

public class PracticeProblem2Main {
    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));
    }
    private static int func2(int[] arr,int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : arr) {
            hashMap.put(element, 100 - element);
            if (hashMap.get(100-element)!=null) {
                if (element != 50) {
                    return 1;
                }
            }
        }
        return 0;
    }
}

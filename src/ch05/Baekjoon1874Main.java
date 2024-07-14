package ch05;

import java.util.*;
import java.util.Stack;

public class Baekjoon1874Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> numberStack = new Stack<>();
        LinkedList<Character> answer = new LinkedList<>();
        int nextNumber = 1;
        int[] numbers = new int[n];

        for (int i = 0; i <n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int num : numbers) {
            if (!numberStack.isEmpty()) {
                if (num == numberStack.peek()) {
                    answer.add('-');
                    numberStack.pop();
                } else if (numberStack.peek() < num) {
                    while (nextNumber <= num) {
                        numberStack.add(nextNumber++);
                        answer.add('+');
                    }
                    answer.add('-');
                    numberStack.pop();
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            } else {
                int lowerBound = nextNumber;
                for (int i = lowerBound; i <= num; i++) {
                    numberStack.add(i);
                    answer.add('+');
                    nextNumber++;
                }
                answer.add('-');
                numberStack.pop();
            }
        }
        for (char ch : answer) {
            System.out.println(ch);
        }
    }
}
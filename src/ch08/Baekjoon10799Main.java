package ch08;

import java.util.Stack;
import java.util.Scanner;

public class Baekjoon10799Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == ')') {
                    stack.pop();
                    answer += 1;
                } else {
                    stack.pop();
                    answer += stack.size();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        System.out.println(answer);
    }
}

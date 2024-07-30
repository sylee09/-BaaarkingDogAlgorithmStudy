package ch08;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon2504Main {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(String.valueOf(ch));
            } else if (ch == ')') {
                long num = 0L;
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        System.exit(0);
                    } else {
                        String top = stack.pop();
                        if (top.equals("[")) {
                            System.out.println(0);
                            System.exit(0);
                        }
                        if (!top.equals("(")&&!top.equals("[")) {
                            num += Long.parseLong(top);
                        }
                        if (top.equals("(")) {
                            if (num == 0) {
                                stack.push("2");
                            } else {
                                num *= 2;
                                stack.push(String.valueOf(num));
                            }
                            break;
                        }
                    }
                }
            } else if (ch == ']') {
                long num = 0L;
                while (true) {
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        System.exit(0);
                    } else {
                        String top = stack.pop();
                        if (top.equals("(")) {
                            System.out.println(0);
                            System.exit(0);
                        }
                        if (!top.equals("(")&&!top.equals("[")) {
                            num += Long.parseLong(top);
                        }
                        if (top.equals("[")) {
                            if (num == 0) {
                                stack.push("3");
                            } else {
                                num *= 3;
                                stack.push(String.valueOf(num));
                            }
                            break;
                        }
                    }
                }
            }
        }
        long answer = 0L;
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(") || top.equals("[")) {
                System.out.println(0);
                System.exit(0);
            } else {
                answer += Long.parseLong(top);
            }
        }
        System.out.println(answer);
    }
}

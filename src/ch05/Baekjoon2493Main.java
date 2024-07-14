package ch05;

import java.util.*;
import java.io.*;
import java.util.Stack;

public class Baekjoon2493Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Tower> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            long height = Long.parseLong(tokenizer.nextToken());

            while (!stack.isEmpty() && stack.peek().height <= height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stringBuilder.append("0 ");
            } else {
                stringBuilder.append(stack.peek().index).append(" ");
            }
            stack.push(new Tower(i, height));
        }
        System.out.println(stringBuilder.toString());
    }
}
class Tower {
    int index;
    long height;

    public Tower(int index, long height) {
        this.index = index;
        this.height = height;
    }
}

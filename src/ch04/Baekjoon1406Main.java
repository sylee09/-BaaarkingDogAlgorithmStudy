package ch04;

import java.io.*;
import java.util.Stack;


public class Baekjoon1406Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : str.toCharArray()) {
            left.push(ch);
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "P":
                    left.push(command[1].charAt(0));
                    break;
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        // Directly build the final result
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            stringBuilder.append(right.pop());
        }

        System.out.println(stringBuilder.toString());
    }
}

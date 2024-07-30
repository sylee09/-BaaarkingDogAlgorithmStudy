package ch08;

import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon4849Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean flag = true;

        while (true) {
            String str = bufferedReader.readLine();
            if (str.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        bufferedWriter.write("no\n");
                        flag = false;
                        break;
                    }
                    char top = stack.pop();
                    if (ch == ')' && top != '(') {
                        bufferedWriter.write("no\n");
                        flag = false;
                        break;
                    } else if (ch == ']' && top != '[') {
                        bufferedWriter.write("no\n");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()) {
                bufferedWriter.write("yes\n");
            } else if (flag) {
                bufferedWriter.write("no\n");
            }
            flag = true;
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

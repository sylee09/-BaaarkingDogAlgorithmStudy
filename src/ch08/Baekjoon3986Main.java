package ch08;

import java.util.Stack;
import java.io.*;

public class Baekjoon3986Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            Stack<Character> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    char top = stack.peek();
                    if (top != ch) {
                        stack.push(ch);
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        bufferedWriter.write(answer+"");
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

package ch08;

import java.util.Stack;
import java.io.*;

public class Baekjoon9012Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        boolean flag;

        for (int i = 0; i < n; i++) {
            flag = true;
            Stack<Character> stack = new Stack<>();
            String str = bufferedReader.readLine();
            for (char ch : str.toCharArray()) {
                if (ch == ')') {
                    if (stack.isEmpty()) {
                        bufferedWriter.write("NO\n");
                        flag = false;
                        break;
                    }
                    if (stack.peek() != '(') {
                        bufferedWriter.write("NO\n");
                        flag = false;
                        break;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) {
                if (flag) {
                    bufferedWriter.write("YES\n");
                }
            } else{
                if (flag) {
                    bufferedWriter.write("NO\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

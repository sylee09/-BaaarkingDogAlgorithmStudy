package ch05;

import java.io.*;
import java.util.*;
import java.util.Stack;

public class Baekjoon6198Main {
    public static void main(String[] args) throws IOException{
        long ans = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        long num;
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            num = Long.parseLong(bufferedReader.readLine());
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            ans += stack.size();
            stack.push(num);
        }
        bufferedWriter.write("" + ans);
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

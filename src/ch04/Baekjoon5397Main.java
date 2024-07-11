package ch04;

import java.io.*;
import java.util.Stack;

public class Baekjoon5397Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String password = bufferedReader.readLine();
            func(password, bufferedWriter);
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
    static void func(String password, BufferedWriter bufferedWriter) throws IOException {
        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();

        for (char ch : password.toCharArray()) {
            if (ch == '<') {
                if (!l.isEmpty()) {
                    r.push(l.pop());
                }
            } else if (ch == '>') {
                if (!r.isEmpty()) {
                    l.push(r.pop());
                }
            } else if (ch == '-') {
                if (!l.isEmpty()) {
                    l.pop();
                }
            } else {
                l.push(ch);
            }
        }
        while (!l.isEmpty()) {
            r.push(l.pop());
        }
        while (!r.isEmpty()) {
            bufferedWriter.write(r.pop());
        }
        bufferedWriter.write("\n");
    }
}

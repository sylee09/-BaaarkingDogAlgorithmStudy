package ch05;

import java.io.*;
import java.util.*;
import java.util.Stack;

public class Baekjoon3015Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Pair> stack = new Stack<>();
        long answer = 0;

        long n = Long.parseLong(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(bufferedReader.readLine());
            Pair newElement = new Pair(num);
            while (!stack.isEmpty() && stack.peek().value <= num) {
                Pair popped = stack.pop();
                answer += popped.same;
                if (num == popped.value) {
                    newElement.same += popped.same;
                }
            }
            if (!stack.isEmpty()) {
                answer += 1;
            }
            stack.push(newElement);
        }
        bufferedWriter.write(answer + "");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
class Pair{
    long value;
    long same;

    public Pair(long value) {
        this.value = value;
        this.same = 1;
    }
}

package ch05;

import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon6549Main {
    static long[] histogram;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;
        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            if (n == 0) {
                break;
            }
            histogram = new long[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Long.parseLong(stringTokenizer.nextToken());
            }
            bufferedWriter.write(getArea(n) + "\n");
            histogram = null;
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
    public static long getArea(int len) {
        Stack<Integer> stack = new Stack<Integer>();
        long maxArea = 0;
        for (int i = 0; i < len; i++) {
            while ((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
                long height = histogram[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            long height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len : len - 1 - stack.peek();
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }
}

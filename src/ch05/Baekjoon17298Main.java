package ch05;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int idx = 0;
        Stack<NGE> stack = new Stack<>();
        int[] ans = new int[n];

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            NGE nge = new NGE(num, idx++);
            while (!stack.isEmpty() && stack.peek().value < num) {
                NGE element = stack.pop();
                ans[element.index] = num;
            }
            stack.push(nge);
        }
        while (!stack.isEmpty()) {
            NGE element = stack.pop();
            ans[element.index] = -1;
        }

        for (int i : ans) {
            bufferedWriter.write(i + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
class NGE{
    int value;
    int index;
    public NGE(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
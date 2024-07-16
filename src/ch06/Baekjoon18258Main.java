package ch06;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon18258Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[2000001];
        int head = 0;
        int tail = 0;
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.contentEquals("push")) {
                int element = Integer.parseInt(stringTokenizer.nextToken());
                arr[tail++] = element;
            } else if (command.contentEquals("front")) {
                if (tail == head) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(arr[head] + "\n");
                }
            } else if (command.contentEquals("back")) {
                if (tail == head) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(arr[tail-1] + "\n");
                }
            } else if (command.contentEquals("size")) {
                bufferedWriter.write(tail - head + "\n");
            } else if (command.contentEquals("empty")) {
                if (tail == head) {
                    bufferedWriter.write(1 + "\n");
                } else {
                    bufferedWriter.write(0 + "\n");
                }
            } else if (command.contentEquals("pop")) {
                if (tail == head) {
                    bufferedWriter.write("-1\n");
                } else {
                    bufferedWriter.write(arr[head++] + "\n");
                }
            } else {
                continue;
            }
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

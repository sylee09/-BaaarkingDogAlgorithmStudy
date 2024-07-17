package ch06;

import java.util.ArrayDeque;
import java.io.*;

public class Baekjoon2164Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int i = 0;
        while (queue.size() != 1) {
            if (i % 2 == 0) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            i++;
        }
        bufferedWriter.write(queue.poll() + "");
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

package ch09;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon9466Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] check;
    static boolean[] finish;
    static int cycles;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int t1 = 0; t1 < t; t1++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] studentChoose = new int[n+1];
            check = new boolean[n + 1];
            finish = new boolean[n + 1];
            cycles = 0;

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int idx = 1;
            while (stringTokenizer.hasMoreTokens()) {
                studentChoose[idx++] = Integer.parseInt(stringTokenizer.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                dfs(studentChoose, i);
            }
            int answer = n - cycles;
            bufferedWriter.write(answer + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void dfs(int[] studentChoose, int idx) {
        int current = idx;
        int next = studentChoose[idx];

        if (!check[current]) {
            check[current] = true;
            dfs(studentChoose, next);
        } else if (!finish[current]) {
            while (next != current) {
                cycles++;
                next = studentChoose[next];
            }
            cycles++;
        }
        finish[current] = true;
    }
}

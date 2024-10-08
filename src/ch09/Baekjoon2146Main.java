package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon2146Main {
    static boolean[][] check;
    static int n;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int[][] landArr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n][n];
        landArr = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int landNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    landArr[i][j] = landNum;
                    dfs(i, j, landNum);
                    landNum++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        bufferedWriter.write(answer + "");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();


    }
    static void bfs(int i, int j) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        check = new boolean[n][n];
        check[i][j] = true;
        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int x = 0; x < size; x++) {
                int[] element = deque.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = element[0] + dx[k];
                    int ny = element[1] + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (!check[nx][ny]) {
                            check[nx][ny] = true;
                            if (landArr[nx][ny] == 0) {
                                deque.add(new int[]{nx, ny});
                            } else {
                                if (landArr[nx][ny] != landArr[i][j]) {
                                    answer = Math.min(answer, level);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
    }

    static void dfs(int i, int j, int landNum) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == 1) {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        landArr[nx][ny] = landNum;
                        dfs(nx, ny, landNum);
                    }
                }
            }
        }
    }
}

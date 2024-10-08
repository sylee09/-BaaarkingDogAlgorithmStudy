package ch09;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2573Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] check;
    static int land;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        while (true) {
            land = 0;
            check = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && !check[i][j]) {
                        dfs(arr, i, j);
                        land++;
                    }
                }
            }
            if (land > 1) {
                ans = cnt;
                break;
            }

            if (land == 0) {
                ans = 0;
                break;
            }

            int[][] temp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] >= 1) {
                        int c = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (arr[nx][ny] == 0) {
                                    c++;
                                }
                            }
                        }
                       temp[i][j] = Math.max(arr[i][j] - c, 0);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = temp[i][j];
                }
            }
            cnt++;


        }

        bufferedWriter.write(ans + "");
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static void dfs(int[][] arr, int i, int j) {
        check[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (arr[nx][ny] != 0) {
                    if (!check[nx][ny]) {
                        dfs(arr, nx, ny);
                    }
                }
            }
        }
    }
}

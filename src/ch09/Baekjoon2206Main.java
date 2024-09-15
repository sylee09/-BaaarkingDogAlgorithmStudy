package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon2206Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static boolean[][][] checked;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n][m];
        checked = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.valueOf(String.valueOf(str.charAt(j)));
            }
        }
        bufferedWriter.write(bfs() + "");
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int bfs() {
        int[] startPoint = new int[]{0, 0, 0};
        checked[0][0][0] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(startPoint);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int wallCheck = point[2];
                if (point[0] == arr.length - 1 && point[1] == arr[0].length - 1) {
                    return level + 1;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = point[0] + dx[k];
                    int ny = point[1] + dy[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == 1) {
                            if (wallCheck == 0) {
                                queue.add(new int[]{nx, ny, wallCheck + 1});
                                checked[nx][ny][wallCheck + 1] = true;
                            }
                        } else {
                            if (!checked[nx][ny][wallCheck]) {
                                queue.add(new int[]{nx, ny, wallCheck});
                                checked[nx][ny][wallCheck] = true;
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

}

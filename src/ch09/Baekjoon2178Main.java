package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon2178Main {
    static int[] direction_x = {1, 0, -1, 0};
    static int[] direction_y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        ArrayDeque<Coordinates2178> deque = new ArrayDeque<>();
        Coordinates2178 coordinate = new Coordinates2178(0, 0);
        int level = 1;
        arr[0][0] = 0;
        deque.add(coordinate);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Coordinates2178 coord = deque.poll();
                if (coord.i == n - 1 && coord.j == m - 1) {
                    bufferedWriter.write(level + "");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedReader.close();
                    System.exit(0);
                }
                for (int k = 0; k < 4; k++) {
                    int nx = coord.i + direction_x[k];
                    int ny = coord.j + direction_y[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == 1) {
                            arr[nx][ny] = 0;
                            deque.add(new Coordinates2178(nx, ny));
                        }
                    }
                }
            }
            level++;
        }
    }
}
class Coordinates2178{
    int i;
    int j;

    public Coordinates2178(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

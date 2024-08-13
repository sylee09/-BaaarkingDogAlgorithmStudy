package ch09;

import java.io.*;
import java.util.ArrayDeque;

public class Baekjoon1012Main{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(String.valueOf(bufferedReader.readLine()));
        for (int i = 0; i < n; i++) {
            int r;
            int c;
            int lava;
            String[] str = bufferedReader.readLine().split(" ");
            r = Integer.parseInt(str[0]);
            c = Integer.parseInt(str[1]);
            lava = Integer.parseInt(str[2]);
            int[][] arr = new int[r][c];

            for (int j = 0; j < lava; j++) {
                int x;
                int y;
                str = bufferedReader.readLine().split(" ");
                x = Integer.parseInt(str[0]);
                y = Integer.parseInt(str[1]);
                arr[x][y] = 1;
            }
            int answer = 0;
            for (int x = 0; x < r; x++) {
                for (int y = 0; y < c; y++) {
                    if (arr[x][y] == 1) {
                        answer++;
                        bfs(arr,x,y);
                    }
                }
            }
            bufferedWriter.write(answer + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void bfs(int[][] arr, int x, int y) {
        int[] direction_x = {1, 0, -1, 0};
        int[] direction_y = {0, 1, 0, -1};

        ArrayDeque<Coordinates1012> deque = new ArrayDeque<>();
        deque.add(new Coordinates1012(x, y));

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Coordinates1012 coord = deque.poll();
                arr[coord.i][coord.j] = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = coord.i + direction_x[k];
                    int ny = coord.j + direction_y[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == 1) {
                            deque.push(new Coordinates1012(nx, ny));
                        }
                    }
                }
            }
        }
    }
}
class Coordinates1012{
    int i;
    int j;

    public Coordinates1012(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

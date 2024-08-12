package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon1926Main {
    static int maxArea=0;
    static int numArea=0;
    static int[] direction_x = {1, 0, -1, 0};
    static int[] direction_y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = bufferedReader.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int[][] arr = new int[r][c];
        for (int i = r - 1; i >= 0; i--) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int idx = 0;
            while (stringTokenizer.hasMoreElements()) {
                arr[i][idx++] = Integer.parseInt(String.valueOf(stringTokenizer.nextElement()));
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    Coordinates coordinates = new Coordinates(i, j);
                    bfs(arr, coordinates);
                }
            }
        }
        bufferedWriter.write(numArea + "\n");
        bufferedWriter.write(maxArea + "");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void bfs(int[][] arr, Coordinates coordinates) {
        numArea++;
        ArrayDeque<Coordinates> deque = new ArrayDeque<>();
        deque.add(coordinates);
        int area = 1;
        arr[coordinates.i][coordinates.j] = 0;

        while (!deque.isEmpty()) {
            int level = deque.size();
            for (int i = 0; i < level; i++) {
                Coordinates c = deque.poll();
                int x = c.i;
                int y = c.j;

                for (int k = 0; k < direction_x.length; k++) {
                    int nx = x + direction_x[k];
                    int ny = y + direction_y[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == 1) {
                            area++;
                            deque.push(new Coordinates(nx, ny));
                            arr[nx][ny] = 0;
                        }
                    }
                }
            }
        }
        maxArea = Math.max(area, maxArea);
    }
}

class Coordinates{
    int i;
    int j;

    public Coordinates(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

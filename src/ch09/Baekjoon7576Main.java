package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Baekjoon7576Main {
    static int[] direction_x = {1, 0, -1, 0};
    static int[] direction_y = {0, 1, 0, -1};
    static int level = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = bufferedReader.readLine().split(" ");
        int r = Integer.parseInt(String.valueOf(s[1]));
        int c = Integer.parseInt(String.valueOf(s[0]));

        int arr[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            s = bufferedReader.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s[j]));
            }
        }

        ArrayList<Coordinates7576> onesCoordinates = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    Coordinates7576 coordinates = new Coordinates7576(i, j);
                    onesCoordinates.add(coordinates);
                }
            }
        }
        bfs(onesCoordinates, arr);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 0) {
                    bufferedWriter.write(-1 + "");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    bufferedReader.close();
                    System.exit(0);
                }
            }
        }

        bufferedWriter.write(level-1 + "");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static void bfs(ArrayList<Coordinates7576> onesCoordinates, int[][] arr) {
        ArrayDeque<Coordinates7576> deque = new ArrayDeque<>();
        for (int i = 0; i < onesCoordinates.size(); i++) {
            deque.add(onesCoordinates.get(i));
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Coordinates7576 coordinates = deque.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = direction_x[k] + coordinates.i;
                    int ny = direction_y[k] + coordinates.j;
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = 1;
                            Coordinates7576 newCoordinates = new Coordinates7576(nx, ny);
                            deque.add(newCoordinates);
                        }
                    }
                }
            }
            level++;
        }
    }
}
class Coordinates7576{
    int i;
    int j;

    public Coordinates7576(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
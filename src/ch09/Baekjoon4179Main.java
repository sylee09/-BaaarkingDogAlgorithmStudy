package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Baekjoon4179Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = bufferedReader.readLine().split(" ");

        int r = Integer.parseInt(String.valueOf(s[0]));
        int c = Integer.parseInt(String.valueOf(s[1]));

        String[][] arr = new String[r][c];

        LinkedList<Coordinates4179> jihoonCoordinates = new LinkedList<>();
        LinkedList<Coordinates4179> fireCoordinates = new LinkedList<>();

        for (int i = r - 1; i >= 0; i--) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
                if (arr[i][j].equals("J")) {
                    jihoonCoordinates.add(new Coordinates4179(i, j));
                } else if (arr[i][j].equals("F")) {
                    fireCoordinates.add(new Coordinates4179(i, j));
                }
            }
        }


        int answer = bfs(jihoonCoordinates, fireCoordinates, arr);
        if (answer != -1) {
            bufferedWriter.write(answer + "");
        } else {
            bufferedWriter.write("IMPOSSIBLE");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    static int bfs(LinkedList<Coordinates4179> jihoonCoordinates, LinkedList<Coordinates4179> fireCoordinates, String[][] arr) {
        int[] direction_x = {1, 0, -1, 0};
        int[] direction_y = {0, 1, 0, -1};
        int level = 0;
        ArrayDeque<Coordinates4179> deque = new ArrayDeque<>();

        int s = jihoonCoordinates.size();
        for (int i = 0; i < s; i++) {
            deque.add(jihoonCoordinates.poll());
        }

        s = fireCoordinates.size();
        for (int i = 0; i < s; i++) {
            deque.add(fireCoordinates.poll());

        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            boolean checkForFire;
            for (int i = 0; i < size; i++) {
                Coordinates4179 coord = deque.poll();
                if (arr[coord.i][coord.j].equals("F")) {
                    checkForFire = true;
                } else {
                    checkForFire = false;
                    if (coord.i == 0 || coord.i == arr.length-1
                            || coord.j == 0 || coord.j == arr[0].length-1) {
                        return level + 1;
                    }
                }
                for (int k = 0; k < 4; k++) {
                    int nx = coord.i + direction_x[k];
                    int ny = coord.j + direction_y[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (checkForFire) {
                            if (arr[nx][ny].equals(".")||arr[nx][ny].equals("J")) {
                                arr[nx][ny] = "F";
                                deque.add(new Coordinates4179(nx, ny));
                            }
                        } else {
                            if (arr[nx][ny].equals(".")) {
                                arr[nx][ny] = "J";
                                deque.add(new Coordinates4179(nx, ny));
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
class Coordinates4179{
    int i;
    int j;
    public Coordinates4179(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

package ch09;

import java.io.*;
import java.util.*;

public class Baekjoon5427Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static char[][] arr;
    static LinkedList<Coordinate> fires;
    static Coordinate person;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            fires = new LinkedList<>();
            arr = new char[a][b];
            checked = new boolean[a][b];

            for (int x = 0; x < a; x++) {
                String lineInput = bufferedReader.readLine();
                for (int y = 0; y < b; y++) {
                    arr[x][y] = lineInput.charAt(y);
                    if (arr[x][y] == '*') {
                        fires.add(new Coordinate(x, y));
                    }
                    if (arr[x][y] == '@') {
                        person = new Coordinate(x, y);
                    }
                }
            }
            bfs(person);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedWriter.close();
    }

    static void bfs(Coordinate person) throws IOException {
        Deque<Coordinate> fireDeque = new LinkedList<>();
        Deque<Coordinate> personDeque = new LinkedList<>();
        int level = 0;
        for (Coordinate fire : fires) {
            fireDeque.add(fire);
            checked[fire.getX()][fire.getY()] = true;
        }
        personDeque.add(person);
        checked[person.getX()][person.getY()] = true;

        while (!personDeque.isEmpty()) {
            int fireSize = fireDeque.size();
            for (int i = 0; i < fireSize; i++) {
                Coordinate fire = fireDeque.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = fire.getX() + dx[k];
                    int ny = fire.getY() + dy[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] != '#') {
                            if (!checked[nx][ny]) {
                                Coordinate newFire = new Coordinate(nx, ny);
                                fireDeque.add(newFire);
                                arr[nx][ny] = '*';
                                checked[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            int personSize = personDeque.size();
            for (int i = 0; i < personSize; i++) {
                person = personDeque.poll();
                if (person.getX() == arr.length - 1 || person.getY() == arr[0].length - 1 || person.getX() == 0 || person.getY() == 0) {
                    bufferedWriter.write(level + 1 + "\n");
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = person.getX() + dx[k];
                    int ny = person.getY() + dy[k];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                        if (arr[nx][ny] == '.') {
                            if (!checked[nx][ny]) {
                                Coordinate newPerson = new Coordinate(nx, ny);
                                personDeque.add(newPerson);
                                checked[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            level++;
        }
        bufferedWriter.write("IMPOSSIBLE\n");
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj.getClass().isInstance(this)) {
                Coordinate that = (Coordinate) obj;
                return that.getX() == x && that.getY() == y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
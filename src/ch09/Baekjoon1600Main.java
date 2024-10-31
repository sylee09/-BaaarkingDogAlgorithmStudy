package ch09;

import java.util.*;

public class Baekjoon1600Main {
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        bfs(arr, k);
        System.out.println(answer);

    }

    static void bfs(int[][] arr, int k) {
        int[] dx_horse = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy_horse = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx_monkey = new int[]{-1, 0, 1, 0};
        int[] dy_monkey = new int[]{0, 1, 0, -1};
        boolean[][][] check = new boolean[arr.length][arr[0].length][k + 1];
        check[0][0][k] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, k, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] element = queue.poll();

                int x_coordinate = element[0];
                int y_coordinate = element[1];
                int num_k = element[2];
                int count = element[3];

                if (x_coordinate == arr.length - 1 && y_coordinate == arr[0].length - 1) {
                    answer = count;
                    return;
                }

                if (num_k > 0) {
                    for (int x = 0; x < 8; x++) {
                        int new_x_coordinate = x_coordinate + dx_horse[x];
                        int new_y_coordinate = y_coordinate + dy_horse[x];
                        if (new_x_coordinate >= 0 && new_x_coordinate < arr.length
                                && new_y_coordinate >= 0 && new_y_coordinate < arr[0].length) {
                            if (!check[new_x_coordinate][new_y_coordinate][num_k - 1] && arr[new_x_coordinate][new_y_coordinate] == 0) {
                                check[new_x_coordinate][new_y_coordinate][num_k - 1] = true;
                                queue.add(new int[]{new_x_coordinate, new_y_coordinate, num_k - 1, count + 1});
                            }
                        }
                    }
                }
                for (int x = 0; x < 4; x++) {
                    int new_x_coordinate = x_coordinate + dx_monkey[x];
                    int new_y_coordinate = y_coordinate + dy_monkey[x];
                    if (new_x_coordinate >= 0 && new_x_coordinate < arr.length
                            && new_y_coordinate >= 0 && new_y_coordinate < arr[0].length) {
                        if (!check[new_x_coordinate][new_y_coordinate][num_k] && arr[new_x_coordinate][new_y_coordinate] == 0) {
                            check[new_x_coordinate][new_y_coordinate][num_k] = true;
                            queue.add(new int[]{new_x_coordinate, new_y_coordinate, num_k, count + 1});
                        }
                    }
                }
            }
        }
    }
}

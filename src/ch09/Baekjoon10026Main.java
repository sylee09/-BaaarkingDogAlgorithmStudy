import java.io.*;
import java.util.*;

public class Baekjoon10026Main {
    static int[] dx = {1, 0, -1, 0}; // 방향 벡터 (상하좌우)
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        boolean[][] visited = new boolean[n][n];

        // 그리드 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // 일반 사람의 구역 수 계산
        int normalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(grid, visited, n, i, j, grid[i][j], false);
                    normalCount++;
                }
            }
        }

        // 적록색약을 위한 새로운 방문 배열 생성
        visited = new boolean[n][n];
        int colorBlindCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(grid, visited, n, i, j, grid[i][j], true);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    static void bfs(char[][] grid, boolean[][] visited, int n, int x, int y, char color, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (isColorBlind) {
                        // 적록색약인 경우 R과 G를 동일하게 처리
                        if ((color == 'R' || color == 'G') && (grid[nx][ny] == 'R' || grid[nx][ny] == 'G')) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        } else if (grid[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    } else {
                        // 일반적인 경우
                        if (grid[nx][ny] == color) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}

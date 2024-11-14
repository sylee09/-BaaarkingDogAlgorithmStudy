package ch12;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon1941 {
    static char[][] arr = new char[5][5];
    static int answer = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0, 0, new LinkedList<Integer>());
        System.out.println(answer);
    }

    static void dfs(int cur, int numY, int level, LinkedList<Integer> list) {
        if (numY >= 4) {
            return;
        }
        if (level == 7) {
            checkConnectionAndAddAnswer(list);
            return;
        }
        if (cur >= 25) {
            return;
        }
        int x = cur / 5;
        int y = cur % 5;
        int nY = numY;

        if (arr[x][y] == 'Y') {
            nY++;
        }
        list.add(cur);
        dfs(cur + 1, nY, level + 1, list);
        list.pollLast();
        dfs(cur + 1, numY, level, list);
    }

    private static void checkConnectionAndAddAnswer(LinkedList<Integer> list) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(list.get(0));
        HashSet<Integer> set = new HashSet<>();
        set.addAll(list);
        boolean[] check = new boolean[25];
        check[list.get(0)] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int element = queue.poll();
            int x = element / 5;
            int y = element % 5;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int next = nx * 5 + ny;
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !check[next] && set.contains(next)) {
                    check[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        if (cnt == 7) {
            answer++;
        }
    }
}

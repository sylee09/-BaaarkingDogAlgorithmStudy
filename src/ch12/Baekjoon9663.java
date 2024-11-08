package ch12;


import java.util.Scanner;

public class Baekjoon9663 {
    static boolean[][] check;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        check = new boolean[n][n];
        dfs(0, n);
        System.out.println(answer);
    }

    static void dfs(int row, int n) {
        if (row == n) {
            answer++;
        } else {
            for (int j = 0; j < n; j++) {
                if (!check[row][j]) {
                    if (checkFunction(row, j, n)) {
                        check[row][j] = true;
                        dfs(row + 1, n);
                        check[row][j] = false;
                    }
                }
            }
        }
    }
    static boolean checkFunction(int row, int col, int n) {
        // 행 비교
        for (int r = row; r >= 0; r--) {
            if (check[r][col]) {
                return false;
            }
        }
        // 왼쪽 대각선 비교
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (check[r][c]) {
                return false;
            }
            r -= 1;
            c -= 1;
        }

        // 오른쪽 대각선 비교
        r = row;
        c = col;
        while (r >= 0 && c <= n - 1) {
            if (check[r][c]) {
                return false;
            }
            r -= 1;
            c += 1;
        }
        return true;
    }
}

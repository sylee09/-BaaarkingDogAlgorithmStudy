package ch01;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println((int)func4(5));
        System.out.println((int)func4(97615282));
        System.out.println((int)func4(1024));
    }
    static double func4(int n) {
        for (int i = 1; i < n; i++) {
            if (Math.pow(2, i) <= n && Math.pow(2, i + 1) > n) {
                return Math.pow(2, i);
            }
        }
        return 0d;
    }
}

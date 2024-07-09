package ch02;

import java.util.Scanner;

public class Baekjoon2490Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String result = scanner.nextLine();
            int cnt = 0;
            for (char ch : result.toCharArray()) {
                if (ch == '0') {
                    cnt++;
                }
            }
            switch(cnt){
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
            }
        }
    }
}

package ch11;

import java.util.Scanner;

public class Baekjoon17478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        func(n, stringBuilder);
    }

    static void func(int n, StringBuilder stringBuilder) {
        if (n == 0) {
            System.out.println(stringBuilder.toString() + "\"재귀함수가 뭔가요?\"");
            System.out.println(stringBuilder.toString() + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(stringBuilder.toString() + "라고 답변하였지.");
        } else {
            System.out.println(stringBuilder.toString() + "\"재귀함수가 뭔가요?\"\n"
                    + stringBuilder.toString() + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
                    + stringBuilder.toString() + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
                    + stringBuilder.toString() + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            func(n - 1, stringBuilder.append("____"));
            stringBuilder.replace(stringBuilder.length() - 4, stringBuilder.length(), "");
            System.out.println(stringBuilder.toString()+"라고 답변하였지.");
        }
    }
}

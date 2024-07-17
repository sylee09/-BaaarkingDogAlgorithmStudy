package ch07;

import java.util.LinkedList;
import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10866Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            if (command.contentEquals("push_back")) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                list.addLast(num);
            } else if (command.contentEquals("push_front")) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                list.addFirst(num);
            } else if (command.contentEquals("front")) {
                if (list.size() == 0) {
                    bufferedWriter.write(-1 + "\n");
                } else {
                    bufferedWriter.write(list.getFirst() + "\n");
                }
            } else if (command.contentEquals("back")) {
                if (list.size() == 0) {
                    bufferedWriter.write(-1 + "\n");
                } else {
                    bufferedWriter.write(list.getLast() + "\n");
                }
            } else if (command.contentEquals("size")) {
                bufferedWriter.write(list.size() + "\n");
            } else if (command.contentEquals("pop_front")) {
                if (list.size() == 0) {
                    bufferedWriter.write(-1 + "\n");
                } else {
                    bufferedWriter.write(list.removeFirst() + "\n");
                }
            } else if (command.contentEquals("pop_back")) {
                if (list.size() == 0) {
                    bufferedWriter.write(-1 + "\n");
                } else {
                    bufferedWriter.write(list.removeLast() + "\n");
                }
            } else if (command.contentEquals("empty")) {
                if (list.size() == 0) {
                    bufferedWriter.write(1 + "\n");
                } else {
                    bufferedWriter.write(0 + "\n");
                }
            } else {
                continue;
            }
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

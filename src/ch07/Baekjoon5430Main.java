package ch07;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon5430Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        boolean errorFlag = false;

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            String command = bufferedReader.readLine();
            int listSize = Integer.parseInt(bufferedReader.readLine());
            String[] arrayForm = bufferedReader.readLine().replace("[", "").replace("]", "").split(",");
            boolean isR = false;
            for (String element : arrayForm) {
                if (!element.contentEquals("")) {
                    int num = Integer.parseInt(element);
                    list.add(num);
                }
            }
            for (char cmd : command.toCharArray()) {
                if (cmd == 'R') {
                    isR = !isR;
                } else if (cmd == 'D') {
                    if (list.size() == 0) {
                        bufferedWriter.write("error\n");
                        errorFlag = true;
                        break;
                    }
                    if (isR) {
                        list.removeLast();
                    } else {
                        list.poll();
                    }
                }
            }
            if (errorFlag) {
                errorFlag = false;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            if (list.size() == 0) {
                stringBuilder.append(']');
            } else {
                if (isR) {
                    while (!list.isEmpty()) {
                        stringBuilder.append(list.removeLast() + ",");
                    }
                } else {
                    while (!list.isEmpty()) {
                        stringBuilder.append(list.poll() + ",");
                    }
                }
                stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "]");
            }
            bufferedWriter.write(stringBuilder + "\n");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

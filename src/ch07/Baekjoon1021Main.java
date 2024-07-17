package ch07;

import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Baekjoon1021Main {
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[m];

        int idx = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(stringTokenizer.nextToken());
        }
        idx = 0;
        int answer = 0;

        while (idx < m) {
            int firstElement = list.getFirst();
            if (firstElement == arr[idx]) {
                idx++;
                list.poll();
            } else {
                int index = list.indexOf(arr[idx]);
                int size = list.size();
                if (index <= size - index) {
                    for (int i = 0; i < index; i++) {
                        answer++;
                        list.addLast(list.removeFirst());
                    }
                } else {
                    for (int i = 0; i < size - index; i++) {
                        answer++;
                        list.addFirst(list.removeLast());
                    }
                }
            }
        }
        bufferedWriter.write(answer + "");
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

}

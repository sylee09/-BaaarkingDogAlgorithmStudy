package ch07;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Baekjoon11003Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int l = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[n];
        int idx = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(stringTokenizer.nextToken());
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.getLast().value > arr[i]) {
                deque.removeLast();
            }
            Node node = new Node(arr[i], i);
            deque.add(node);
            if (i - l >= deque.getFirst().index) {
                deque.removeFirst();
            }
            bufferedWriter.write(deque.getFirst().value + " ");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
class Node{
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
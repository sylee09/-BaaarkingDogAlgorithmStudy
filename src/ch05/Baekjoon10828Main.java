package ch05;


import java.io.*;

public class Baekjoon10828Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        ImplementedStack stack = new ImplementedStack();
        for (int i = 0; i < n; i++) {
            String[] command = bufferedReader.readLine().split(" ");
            if (command[0].contentEquals("push")) {
                stack.push(Integer.parseInt(command[1]));
            } else if (command[0].contentEquals("pop")) {
                bufferedWriter.write(stack.pop() + "\n");
            } else if (command[0].contentEquals("size")) {
                bufferedWriter.write(stack.size() + "\n");
            } else if (command[0].contentEquals("empty")) {
                bufferedWriter.write(stack.empty() + "\n");
            } else if (command[0].contentEquals("top")) {
                bufferedWriter.write(stack.top() + "\n");
            } else {
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class ImplementedStack {
    static final int n = 10000;
    int[] arr;
    int pos;

    public ImplementedStack(){
        arr = new int[n + 1];
        pos = 0;
    }

    public void push(int x) {
        arr[pos++] = x;
    }

    public int pop() {
        if (pos == 0) {
            return -1;
        }
        return arr[--pos];
    }

    public int size() {
        return pos;
    }

    public int empty() {
        if (pos == 0) {
            return 1;
        }
        return 0;
    }

    public int top() {
        if (pos == 0) {
            return -1;
        }
        return arr[pos - 1];
    }
}

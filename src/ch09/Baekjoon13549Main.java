package ch09;

import java.io.*;
import java.util.*;

public class Baekjoon13549Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        boolean[] check = new boolean[100001];
        Deque<LinkedList<Integer>> queue = new ArrayDeque<>();
        boolean flag = false;
        int answer=0;

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        list.add(n);
        list.add(0);
        queue.add(list);

        while (!queue.isEmpty()&&!flag) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                LinkedList<Integer> element = queue.poll();
                check[element.get(0)] = true;
                int position = element.get(0);
                int time = element.get(1);

                if (position == k) {
                    flag = true;
                    answer = time;
                    break;
                }

                for (int x = 0; x < 3; x++) {
                    int newCoordinate = position;
                    int newTime = time;
                    switch(x) {
                        case 0:
                            newCoordinate-=1;
                            newTime+=1;
                            if (newCoordinate >= 0 && newCoordinate < 100001 && !check[newCoordinate]) {
                                list = new LinkedList<>();
                                list.add(newCoordinate);
                                list.add(newTime);
                                queue.add(list);
                            }
                            break;
                        case 1:
                            newCoordinate += 1;
                            newTime += 1;
                            if (newCoordinate >= 0 && newCoordinate < 100001 && !check[newCoordinate]) {
                                list = new LinkedList<>();
                                list.add(newCoordinate);
                                list.add(newTime);
                                queue.add(list);
                            }
                            break;
                        case 2:
                            newCoordinate *= 2;
                            if (newCoordinate >= 0 && newCoordinate < 100001 && !check[newCoordinate]) {
                                list = new LinkedList<>();
                                list.add(newCoordinate);
                                list.add(newTime);
                                queue.addFirst(list);
                            }
                            break;
                    }
                }
            }
        }
        bufferedWriter.write(answer + "");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

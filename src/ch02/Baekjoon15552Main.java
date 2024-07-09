package ch02;

import java.io.*;

public class Baekjoon15552Main {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;
        try{
            n = Integer.parseInt(reader.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < n; i++) {
            try {
                String[] str = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                writer.write((a + b)+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

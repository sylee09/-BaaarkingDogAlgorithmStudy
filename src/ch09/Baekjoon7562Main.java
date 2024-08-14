package ch09;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon7562Main {
    static Set<Coordinates7562> set;

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] direction_x = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] direction_y = {-2, -1, 1, 2, 2, 1, -1, -2};

        int numTest = Integer.parseInt(String.valueOf(bufferedReader.readLine()));
        for (int t = 0; t < numTest; t++) {
            int chessBoardLength = Integer.parseInt(String.valueOf(bufferedReader.readLine()));
            set = new HashSet<>();

            String[] s = String.valueOf(bufferedReader.readLine()).split(" ");
            Coordinates7562 curPos = new Coordinates7562(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            s = String.valueOf(bufferedReader.readLine()).split(" ");
            Coordinates7562 targetPos = new Coordinates7562(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            ArrayDeque<Coordinates7562> deque = new ArrayDeque<>();
            deque.add(curPos);

            int level = 0;
            boolean found = false;

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Coordinates7562 curPosition = deque.poll();

                    for (int k = 0; k < 8; k++) {
                        int nm = curPosition.i + direction_x[k];
                        int nn = curPosition.j + direction_y[k];
                        if (nm >= 0 && nm < chessBoardLength && nn >= 0 && nn < chessBoardLength) {
                            Coordinates7562 newCoordinates = new Coordinates7562(nm, nn);
                            if (curPosition.equals(targetPos)) {
                                bufferedWriter.write(level+"\n");
                                found = true;
                                break;
                            }
                            if (!set.contains(newCoordinates)) {
                                set.add(newCoordinates);
                                deque.add(newCoordinates);
                            }
                        }
                    }
                }
                if(found) break;
                level++;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
class Coordinates7562{
    int i;
    int j;

    public Coordinates7562(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj==null||getClass() != obj.getClass()) return false;

        Coordinates7562 coord = (Coordinates7562) obj;

        return i == coord.i && j == coord.j;
    }

    @Override
    public int hashCode() {
        return 31 * i + j;
    }
}

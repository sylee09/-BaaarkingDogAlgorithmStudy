package ch01;

import java.util.ArrayList;
public class Problem2 {
    public static void main(String[] args) {
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));

    }
    private static int func2(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==100){
                    return 1;
                }
            }
        }
        return 0;
    }
}

package ch01;

public class Problem1 {
    public static void main(String[] args){
        System.out.println(func1(16));
        System.out.println(func1(34567));
        System.out.println(func1(27639));
    }
    // 시간 복잡도 = O(N)
    private static int func1(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%3==0||i%5==0){
                sum += i;
            }
        }
        return sum;
    }
}

package ch01;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(func3(9));
        System.out.println(func3(693953651));
        System.out.println(func3(756580036));

    }
    static int func3(int n){
        for(int i=1;i<n;i++){
            if(Math.pow(i,2)==n){
                return 1;
            }
        }
        return 0;
    }
}

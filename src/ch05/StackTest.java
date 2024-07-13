package ch05;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.test();

    }
}
class Stack{
    public final int MX = 1000005;
    int[] dat;
    int pos;

    public Stack(){
        pos = 0;
        dat = new int[MX];
    }

    public void push(int x) {
        dat[pos] = x;
        pos++;
    }

    public int pop(){
        return dat[--pos];
    }

    public int top(){
        return dat[pos - 1];
    }
    public void test(){
        this.push(5);
        this.push(4);
        this.push(3);
        System.out.println(this.top());
        System.out.println();
        this.pop();
        this.pop();
        System.out.println(this.top());
        System.out.println();
        this.push(10);
        this.push(12);
        System.out.println(this.top());
        System.out.println();
        this.pop();
        System.out.println(this.top());
        System.out.println();
    }
}

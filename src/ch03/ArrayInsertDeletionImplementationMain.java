package ch03;

public class ArrayInsertDeletionImplementationMain {
    static int len;
    public static void main(String[] args) {
        insert_test();
        erase_test();
    }
    static void insert(int idx, int num, int arr[]){
        if (len > arr.length) {
            return;
        }
        if (idx >= len) {
            arr[len] = num;
        } else {
            for (int i = len; i > idx; i--) {
                arr[i] = arr[i - 1];
                if (i == idx + 1) {
                    arr[idx] = num;
                }
            }
        }
        len++;
    }
    static void erase(int idx, int arr[]) {
        for (int i=idx;i<len;i++) {
            arr[i] = arr[i+1];
        }
        len--;
    }
    static void printArr(int arr[]) {
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.printf("\n\n");
    }
    static void insert_test(){
        System.out.println("***** insert_test *****");
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        len = 3;
        insert(3, 40, arr);
        printArr(arr);
        insert(1, 50, arr);
        printArr(arr);
        insert(0, 15, arr);
        printArr(arr);
    }
    static void erase_test(){
        System.out.println("***** erase_test *****");
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 40;
        arr[3] = 30;
        arr[4] = 70;
        arr[5] = 20;
        len = 6;
        erase(4, arr);
        printArr(arr);
        erase(1, arr);
        printArr(arr);
        erase(3, arr);
        printArr(arr);
    }
}

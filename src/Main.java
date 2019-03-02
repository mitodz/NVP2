import java.util.Scanner;

public class Main {


    private int binarySearch(int a[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && a[T[middle]] >= s && s > a[T[middle+1]]){
                return middle+1;
            }else if(a[T[middle]] >= s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }

    public void lis(int a[]){
        int T[] = new int[a.length];
        int R[] = new int[a.length];
        for(int i=0; i < R.length ; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for(int i=1; i < a.length; i++){
            if(a[T[0]] < a[i]){
                T[0] = i;
            }else if(a[T[len]] >= a[i]){
                len++;
                T[len] = i;
                R[T[len]] = T[len-1];
            }else{
                int index = binarySearch(a, T, len,a[i]);
                T[index] = i;
                R[T[index]] = T[index-1];
            }
        }
        System.out.println(len + 1);
        int index = T[len];
        int[]res = new int[len + 1];
        int j = len;
        while(index != -1 && j >= 0) {
            res[j] = index + 1;
            index = R[index];
            j--;
        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Main lis = new Main();
        lis.lis(a);
    }
}
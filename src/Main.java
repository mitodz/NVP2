import java.util.Scanner;

public class Main {

    public static int LISBottomUP(int[] a) {
        int n = a.length;
        int[] d = new int [n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (a[j] < a[i] && d[j] + 1 > d[i] && a[i] % a[j] == 0) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans > d[i] ? ans : d[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(LISBottomUP(a));
    }
}

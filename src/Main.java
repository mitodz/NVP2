import java.util.Scanner;

public class Main {

    public static void LISBottomUP(int[] a) {
        int n = a.length;
        int[] d = new int [n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (a[j] >= a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int ans = 0;
        int imax = 0;
        for (int i = 0; i < n; i++) {
            if (ans <= d[i]) {
                ans = d[i];
                imax = i;
            }
        }
        System.out.println(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(imax + 1);
        for (int j = imax; j > 0; j--) {
            if (d[j - 1] < imax + 1 && a[j - 1] >= a[j]) {
                imax = j - 1;
                sb.append(" ").append(imax + 1);
            }
        }
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        LISBottomUP(a);
    }
}

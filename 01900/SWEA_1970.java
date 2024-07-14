import java.io.*;

public class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] ans = new int[8];
            for (int i = 0; i < 8; i++) {
                ans[i] = N / arr[i];
                N %= arr[i];
            }
            System.out.println("#" + t);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
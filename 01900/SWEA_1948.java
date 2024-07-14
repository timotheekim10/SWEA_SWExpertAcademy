import java.io.*;
import java.util.*;

public class Solution {
    static int T;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            int sum1 = 0;
            int sum2 = 0;
            for (int i = 1; i < m1; i++) {
                sum1 += arr[i-1];
            }
            sum1 += d1;
            for (int i = 1; i < m2; i++) {
                sum2 += arr[i-1];
            }
            sum2 += d2;

            System.out.println("#" + t + " " + (sum2 - sum1 + 1));
        }
    }
}
import java.util.*;
import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int smallNum, bigNum;
            int[] smallArr, bigArr;
            if (n < m) {
                smallNum = n;
                bigNum = m;
                smallArr = new int[n];
                bigArr = new int[m];

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    smallArr[i] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    bigArr[j] = Integer.parseInt(st.nextToken());
                }
            } else {
                smallNum = m;
                bigNum = n;
                smallArr = new int[m];
                bigArr = new int[n];

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    bigArr[i] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    smallArr[j] = Integer.parseInt(st.nextToken());
                }
            }

            long max = Long.MIN_VALUE;
            for (int i = 0; i < bigNum - smallNum + 1; i++) {
                long sum = 0;
                for (int j = 0; j < smallNum; j++) {
                    sum += (long) smallArr[j] * bigArr[i + j];
                }
                max = Math.max(max, sum);
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
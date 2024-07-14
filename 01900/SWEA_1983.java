import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            double[][] arr = new double[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = i + 1;
                double score = Integer.parseInt(st.nextToken()) * 0.35 + Integer.parseInt(st.nextToken()) * 0.45 + Integer.parseInt(st.nextToken()) * 0.2;
                arr[i][1] = score;
            }
            Arrays.sort(arr, (o1, o2) -> {
                return Double.compare(o2[1], o1[1]);
            });

            for (int i = 0; i < N; i++) {
                if (arr[i][0] == K) {
                    System.out.print("#" + t + " ");
                    if (i < N * 0.1) {
                        System.out.println("A+");
                    } else if (i < N * 0.2) {
                        System.out.println("A0");
                    } else if (i < N * 0.3) {
                        System.out.println("A-");
                    } else if (i < N * 0.4) {
                        System.out.println("B+");
                    } else if (i < N * 0.5) {
                        System.out.println("B0");
                    } else if (i < N * 0.6) {
                        System.out.println("B-");
                    } else if (i < N * 0.7) {
                        System.out.println("C+");
                    } else if (i < N * 0.8) {
                        System.out.println("C0");
                    } else if (i < N * 0.9) {
                        System.out.println("C-");
                    } else {
                        System.out.println("D0");
                    }
                }
            }
        }
    }
}
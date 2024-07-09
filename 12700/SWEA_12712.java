import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sumPlus = graph[i][j];
                    int sumX = graph[i][j];

                    // + 모양 합 계산
                    for (int k = 1; k < M; k++) {
                        if ((0 <= i+k) && (i+k < N) && (0 <= j) && (j < N)) {
                            sumPlus += graph[i+k][j];
                        }
                        if ((0 <= i-k) && (i-k < N) && (0 <= j) && (j < N)) {
                            sumPlus += graph[i-k][j];
                        }
                        if ((0 <= i) && (i < N) && (0 <= j+k) && (j+k < N)) {
                            sumPlus += graph[i][j+k];
                        }
                        if ((0 <= i) && (i < N) && (0 <= j-k) && (j-k < N)) {
                            sumPlus += graph[i][j-k];
                        }
                    }

                    // x 모양 합 계산
                    for (int k = 1; k < M; k++) {
                        if ((0 <= i+k) && (i+k < N) && (0 <= j+k) && (j+k < N)) {
                            sumX += graph[i+k][j+k];
                        }
                        if ((0 <= i+k) && (i+k < N) && (0 <= j-k) && (j-k < N)) {
                            sumX += graph[i+k][j-k];
                        }
                        if ((0 <= i-k) && (i-k < N) && (0 <= j-k) && (j-k < N)) {
                            sumX += graph[i-k][j-k];
                        }
                        if ((0 <= i-k) && (i-k < N) && (0 <= j+k) && (j+k < N)) {
                            sumX += graph[i-k][j+k];
                        }
                    }

                    int temp = Math.max(sumPlus, sumX);
                    max = Math.max(max, temp);
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
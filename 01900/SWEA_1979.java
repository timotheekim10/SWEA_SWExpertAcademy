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
            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1) {
                        cnt++;
                    }
                    if (graph[i][j] == 0 || j == N - 1) {
                        if (cnt == K) {
                            ans++;
                        }
                        cnt = 0;
                    }
                }
                for (int j = 0; j < N; j++) {
                    if (graph[j][i] == 1) {
                        cnt++;
                    }
                    if (graph[j][i] == 0 || j == N - 1) {
                        if (cnt == K) {
                            ans++;
                        }
                        cnt = 0;
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] strArr = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(strArr[j]);
                }
            }
            int ans = 0;
            for (int i = 0; i <= N/2; i++) {
                for (int j = N/2 - i; j <= N/2 + i; j++) {
                    ans += graph[i][j];
                }
            }
            for (int i = N - 1; i >= N/2 + 1; i--) {
                for (int j = N/2 + i - (N-1); j <= N/2 + N - 1 - i; j++) {
                    ans += graph[i][j];
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
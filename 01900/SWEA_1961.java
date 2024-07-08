import java.util.*;
import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[][] data = new String[N][N];
            String[][] result = new String[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = st.nextToken();
                }
            }
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = N; j > 0; j--) {
                    sb.append(data[j-1][i]);
                }
                result[i][0] = String.valueOf(sb);
            }
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = N; j > 0; j--) {
                    sb.append(data[N-i-1][j-1]);
                }
                result[i][1] = String.valueOf(sb);
            }
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = N; j > 0; j--) {
                    sb.append(data[N-j][N-i-1]);
                }
                result[i][2] = String.valueOf(sb);
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
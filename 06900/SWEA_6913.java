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
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0, max = 0;

            for (int i = 0; i < N; i++) {
                int temp = 0;
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        temp += 1;
                    }
                }
                if (temp > max) {
                    cnt = 1;
                    max = temp;
                } else if (temp == max) {
                    cnt += 1;
                }
            }

            System.out.println("#" + t + " " + cnt + " " + max);
        }
    }
}
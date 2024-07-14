import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int x = 0;
            int ans = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C1 = Integer.parseInt(st.nextToken());
                int C2;
                if (C1 == 0) {
                    ans += x;
                } else if (C1 == 1) {
                    C2 = Integer.parseInt(st.nextToken());
                    x += C2;
                    ans += x;
                } else if (C1 == 2) {
                    C2 = Integer.parseInt(st.nextToken());
                    x = (C2 > x) ? 0 : x - C2;
                    ans += x;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
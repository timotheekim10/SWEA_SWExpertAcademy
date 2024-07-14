import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int cnt = 0;
            boolean[] visited = new boolean[10];
            int N = Integer.parseInt(br.readLine());
            int ans = 0;

            while (cnt < 10) {
                ans += N;
                String s = Integer.toString(ans);
                for (int i = 0; i < s.length(); i++) {
                    int c = Character.getNumericValue(s.charAt(i));
                    if (!visited[c]) {
                        visited[c] = true;
                        cnt += 1;
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
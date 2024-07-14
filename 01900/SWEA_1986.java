import java.io.*;

public class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                ans += (i%2 == 0 ? -i : i);
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
import java.io.*;
import java.util.*;

public class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int m = (m1 + m2) % 60;
            int temp = (m1 + m2 >= 60 ? 1 : 0);
            int h = (h1 + h2 + temp >= 12 ? h1 + h2 + temp - 12 : h1 + h2 + temp);

            System.out.println("#" + t + " " + h + " " + m);
        }
    }
}
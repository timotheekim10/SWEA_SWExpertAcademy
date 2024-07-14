import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            String ans = new String(Base64.getDecoder().decode(s));
            System.out.println("#" + t + " " + ans);
        }
    }
}
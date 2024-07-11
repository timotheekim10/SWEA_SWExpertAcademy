import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            for (int i = 1; i <= 10; i++) {
                String p1 = s.substring(0, i);
                String p2 = s.substring(i, 2 * i);
                if (p1.equals(p2)) {
                    System.out.println("#" + t + " " + p1.length());
                    break;
                }
            }
        }
    }
}
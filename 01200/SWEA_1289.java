import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int ans = 0;
            String temp = "0";
            String[] strArr = br.readLine().split("");
            for (int i = 0; i < strArr.length; i++) {
                if (!strArr[i].equals(temp)) {
                    ans += 1;
                    if (temp.equals("0")) {
                        temp = "1";
                    } else {
                        temp = "0";
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
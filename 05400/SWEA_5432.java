import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] arr = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("(")) {
                    stack.push("(");
                } else if (arr[i].equals(")")) {
                    if (arr[i-1].equals("(")) {
                        stack.pop();
                        ans += stack.size();
                    } else if (arr[i-1].equals(")")) {
                        stack.pop();
                        ans += 1;
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }
}
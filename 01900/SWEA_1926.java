import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static List<String> list = Arrays.asList("3", "6", "9");

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String str = Integer.toString(i);
            String[] strArr = str.split("");
            List<String> strList = new ArrayList<>(Arrays.asList(strArr));

            boolean is369 = false;
            for (String x : list) {
                if (strList.contains(x)) {
                    is369 = true;
                }
            }

            if (is369) {
                for (String s : strList) {
                    if (list.contains(s)) {
                        System.out.print("-");
                    }
                }
            } else {
                System.out.print(i);
            }

            System.out.print(" ");
        }
    }
}
import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int temp = 0;
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String C = st.nextToken();
                int K = Integer.parseInt(st.nextToken());
                for (int j = 0; j < K; j++) {
                    list.add(C);
                }
            }
            System.out.println("#" + t);
            for (int i = 1; i <= list.size(); i++) {
                System.out.print(list.get(i-1));
                if (i % 10 == 0) {
                    System.out.println();
                }
                if (i == list.size()) {
                    System.out.println();
                }
            }
        }
    }
}
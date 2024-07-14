import java.io.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[] {2, 3, 5, 7, 11};
            System.out.print("#" + t + " ");
            for (int i = 0; i < 5; i++) {
                if (N == 0) {
                    System.out.print(0 + " ");
                    continue;
                }
                int cnt = 0;
                while (N % arr[i] == 0) {
                    cnt += 1;
                    N /= arr[i];
                }
                System.out.print(cnt + " ");
            }
            System.out.println();
        }
    }
}
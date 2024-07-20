import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            ArrayList<Integer> dpAsc = new ArrayList<>();
            dpAsc.add(0);
            ArrayList<Integer> dpDesc = new ArrayList<>();
            dpDesc.add(0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N-1; i++) {
                if (arr[i] < arr[i+1]) {
                    dpAsc.add(arr[i+1] - arr[i]);
                } else if (arr[i] > arr[i+1]) {
                    dpDesc.add(arr[i] - arr[i+1]);
                }
            }

            System.out.println("#" + t + " " + Collections.max(dpAsc) + " " + Collections.max(dpDesc));
        }
    }
}
import java.io.*;
import java.util.*;

class Solution {
    static int T;
    static int ans = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] tArr = new int[N];
            int[] kArr = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                tArr[i] = Integer.parseInt(st.nextToken());
                kArr[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }
            boolean[] sel = new boolean[N];
            recursive(0, 0, sel, arr, tArr, kArr, L);
            System.out.println("#" + t + " " + ans);
            ans = 0;
        }
    }

    private static void recursive(int idx, int k, boolean[] sel, int[] arr, int[] tArr, int[] kArr, int L) {
        int tSum = 0, kSum = 0;
        if (idx == arr.length) {
            for (int i = 0; i < sel.length; i++) {
                if (sel[i] == true) {
                    tSum += tArr[arr[i]];
                    kSum += kArr[arr[i]];
                }
            }
            if (kSum <= L) {
                ans = Math.max(ans, tSum);
            }
            return;
        }
        sel[idx] = true;
        recursive(idx + 1, k + 1, sel, arr, tArr, kArr, L);
        sel[idx] = false;
        recursive(idx + 1, k, sel, arr, tArr, kArr, L);
    }
}
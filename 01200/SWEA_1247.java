import java.io.*;
import java.util.*;

class Solution {
    static int T;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            int[] xArr = new int[N];
            int[] yArr = new int[N];
            for (int i = 0; i < N; i++) {
                xArr[i] = Integer.parseInt(st.nextToken());
                yArr[i] = Integer.parseInt(st.nextToken());
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i;
            }
            boolean[] v = new boolean[arr.length];
            recursive(arr, new int[arr.length], 0, v, cx, cy, hx, hy, xArr, yArr);
            System.out.println("#" + t + " " + min);
            min = Integer.MAX_VALUE;
        }
    }

    private static void recursive(int[] arr, int[] sel, int k, boolean[] v, int cx, int cy, int hx, int hy, int[] xArr, int[] yArr) {
        if (k == sel.length) {
            int ans = 0;
            ans += (Math.abs(xArr[sel[0]]-cx) + Math.abs(yArr[sel[0]]-cy));
            for(int i = 1; i < k; i++) {
                ans += (Math.abs(xArr[sel[i]]-xArr[sel[i-1]]) + Math.abs(yArr[sel[i]]-yArr[sel[i-1]]));
            }
            ans += (Math.abs(hx-xArr[sel[k-1]]) + Math.abs(hy-yArr[sel[k-1]]));
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (v[i] != true) {
                v[i] = true;
                sel[k] = arr[i];
                recursive(arr, sel, k + 1, v, cx, cy, hx, hy, xArr, yArr);
                v[i] = false;
            }
        }
    }
}
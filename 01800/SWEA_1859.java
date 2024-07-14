import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            long ans = 0;
            while (q.size() > 0) {
                int maxVal = findMax(q);
                int maxIdx = findMaxIdx(q, maxVal);
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = 0; i < maxIdx + 1; i++) {
                    arr.add(q.poll());
                }
                for (int x : arr) {
                    ans += arr.get(arr.size() - 1) - x;
                }
            }
            System.out.println("#" + t + " " + ans);
        }
    }

    private static int findMax(Queue<Integer> q) {
        int maxVal = Integer.MIN_VALUE;
        for (int val : q) {
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    private static int findMaxIdx(Queue<Integer> q, int maxVal) {
        int idx = 0;
        int maxIdx = 0;
        for (int val : q) {
            if (val == maxVal) {
                maxIdx = idx;
                break;
            }
            idx++;
        }
        return maxIdx;
    }
}
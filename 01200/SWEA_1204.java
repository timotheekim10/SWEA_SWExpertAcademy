import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int testCase = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            list.sort((o1, o2) -> {
                int compare = map.get(o2).compareTo(map.get(o1));
                if (compare == 0) {
                    return o2.compareTo(o1);
                }
                return compare;
            });
            System.out.println("#" + t + " " + list.get(0));
        }
    }
}
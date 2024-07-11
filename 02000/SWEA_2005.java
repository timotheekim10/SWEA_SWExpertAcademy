import java.io.*;
import java.util.*;

class Solution {
    static int T;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(1, 1)));
        for (int i = 2; i < 10; i++) {
            list.add(new ArrayList<>(Arrays.asList(1)));
            for (int j = 0; j < list.get(i-1).size() - 1; j++) {
                list.get(i).add(list.get(i-1).get(j) + list.get(i-1).get(j+1));
            }
            list.get(i).add(1);
        }

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int x : list.get(i)) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
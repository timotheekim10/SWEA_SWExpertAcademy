import java.io.*;
import java.util.*;

public class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            Integer[][] arr = new Integer[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean checkA = true;
            boolean checkB = true;
            boolean checkC = true;

            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr[i]));
                if (set.size() != 9) {
                    checkA = false;
                    break;
                }
            }

            for (int i = 0; i < 9; i++) {
                Set<Integer> set = new HashSet<Integer>();
                for (int j = 0; j < 9; j++) {
                    set.add(arr[j][i]);
                }
                if (set.size() != 9) {
                    checkB = false;
                    break;
                }
            }

            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    Set<Integer> set = new HashSet<Integer>();
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            set.add(arr[k][l]);
                        }
                    }
                    if (set.size() != 9) {
                        checkC = false;
                        break;
                    }
                }
            }

            System.out.println("#" + t + " " + (checkA && checkB && checkC ? 1 : 0));
        }
    }
}
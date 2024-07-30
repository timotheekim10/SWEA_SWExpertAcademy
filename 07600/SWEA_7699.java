package test;

import java.io.*;
import java.util.*;

class Solution {
    static int T;
    static String[][] graph;
    static boolean[][] visited;
    static Map<String, Boolean> data = new HashMap<>();
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int R, C;
    static int ans;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 65; i < 91; i++) {
                data.put(Character.toString((char) i), false);
            }
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph = new String[R][C];
            visited = new boolean[R][C];
            ans = 0;
            for (int i = 0; i < R; i++) {
                String[] arr = br.readLine().split("");
                for (int j = 0; j < C; j++) {
                    graph[i][j] = arr[j];
                }
            }
            visited[0][0] = true;
            data.put(graph[0][0], true);
            dfs(0, 0, 1);
            System.out.println("#" + t + " " + ans);
        }
    }

    static void dfs(int r, int c, int cnt) {
        ans = Math.max(ans, cnt);
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && !data.get(graph[nr][nc])) {
                visited[nr][nc] = true;
                data.put(graph[nr][nc], true);
                dfs(nr, nc, cnt + 1);
                visited[nr][nc] = false;
                data.put(graph[nr][nc], false);
            }
        }
    }
}
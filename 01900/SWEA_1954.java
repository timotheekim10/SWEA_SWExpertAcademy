import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int[] dx = new int[] {0, 1, 0, -1};
            int[] dy = new int[] {1, 0, -1, 0};
            int x = 0;
            int y = 0;
            graph[x][y] = 1;
            visited[x][y] = true;
            int d = 0;
            for (int i = 0; i < N * N - 1; i++) {
                if ((x + dx[d] < 0) || (x + dx[d] >= N) || (y + dy[d] < 0) || (y + dy[d] >= N) || (visited[x+dx[d]][y+dy[d]])) {
                    int nd = (d + 1) % 4;
                    int nx = x + dx[nd];
                    int ny = y + dy[nd];
                    graph[nx][ny] = graph[x][y] + 1;
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                    d = nd;
                } else {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    graph[nx][ny] = graph[x][y] + 1;
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
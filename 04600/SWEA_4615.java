import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N][N];
            int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
            for(int i = (N-1)/2; i < (N-1)/2+2; i++) {
                for(int j = (N-1)/2; j < (N-1)/2+2; j++) {
                    graph[i][j] = ((i+j)%2 == 0) ? 2 : 1;
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());

                graph[x][y] = s;

                for (int j = 0; j < 8; j++) {
                    ArrayList<Integer> arrX = new ArrayList<>();
                    ArrayList<Integer> arrY = new ArrayList<>();
                    boolean val = false;
                    int cnt = 0;
                    int nx = x+dx[j];
                    int ny = y+dy[j];
                    while (0<=nx && nx<N && 0<=ny && ny<N) {
                        if (graph[nx][ny] == 0) {
                            break;
                        }
                        if (graph[nx][ny] == s) {
                            val = true;
                            break;
                        }
                        arrX.add(nx);
                        arrY.add(ny);
                        nx += dx[j];
                        ny += dy[j];
                    }
                    if (val) {
                        for (int v = 0; v < arrX.size(); v++) {
                            graph[arrX.get(v)][arrY.get(v)] = (s == 1) ? 1 : 2;
                        }
                    }
                }
            }

            int bCnt = 0;
            int wCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1) {
                        bCnt++;
                    } else if (graph[i][j] == 2) {
                        wCnt++;
                    }
                }
            }

            System.out.println("#" + t + " " + bCnt + " " + wCnt);
        }
    }
}
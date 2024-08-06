import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;
	int time;
	
	public Point(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

class Solution {
    static int T, N;
    static int[][] graph;
    static boolean[][] v;
    static int sx, sy; // 출발지
    static int ex, ey; // 도착지
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	graph = new int[N][N];
        	v = new boolean[N][N];
        	ans = Integer.MAX_VALUE;
        	StringTokenizer st;
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < N; j++) {
        			graph[i][j] = Integer.parseInt(st.nextToken());
    			}
			}
        	st = new StringTokenizer(br.readLine());
        	sx = Integer.parseInt(st.nextToken());
        	sy = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	ex = Integer.parseInt(st.nextToken());
        	ey = Integer.parseInt(st.nextToken());
        	
        	bfs();
        	
        	if (ans != Integer.MAX_VALUE) {
        		System.out.println("#" + test_case + " " + ans);
        	} else {
        		System.out.println("#" + test_case + " " + -1);
        	}
        }
    }

	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(sx, sy, 0));
		while (!(q.isEmpty())) {
			Point current = q.poll();
			int x = current.x;
			int y = current.y;
			v[x][y] = true;
			if (x==ex && y==ey) {
				ans = Math.min(ans, current.time);
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0<=nx && nx<N && 0<=ny && ny<N && !v[nx][ny] && graph[nx][ny]!=1) {
					if (graph[nx][ny] == 2) {
						if (current.time%3 == 2) {
							q.offer(new Point(nx, ny, current.time + 1));
						} else if (current.time%3 == 1) {
							q.offer(new Point(nx, ny, current.time + 2));
						} else {
							q.offer(new Point(nx, ny, current.time + 3));
						}
					} else {
						q.offer(new Point(nx, ny, current.time + 1));
					}
				}
			}
		}
	}
}
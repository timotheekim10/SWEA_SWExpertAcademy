import java.io.*;

public class Solution {
	static int T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1 ,0};
			int d = 0;
			int[][] graph = new int[N][N];
			int x = 0, y = 0;
			for (int i = 1; i <= N*N; i++) {
				graph[x][y] = i;
				x += dx[d];
				y += dy[d];
				if (x < 0 || x >= N || y < 0 || y >= N || graph[x][y] != 0) {
					x -= dx[d];
					y -= dy[d];
					d = (d + 1) % 4;
					x += dx[d];
					y += dy[d];
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
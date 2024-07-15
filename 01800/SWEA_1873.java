import java.io.*;
import java.util.*;

class Solution {
    static int T;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            String[][] graph = new String[H][W];
            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                String[] arr = s.split("");
                graph[i] = arr;
            }
            int N = Integer.parseInt(br.readLine());
            String command_str = br.readLine();
            String[] command_arr = command_str.split("");
            int x = 0, y = 0;
            loopOut:for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (graph[i][j].equals("<") || graph[i][j].equals(">") || graph[i][j].equals("v") || graph[i][j].equals("^")) {
                        x = i;
                        y = j;
                        break loopOut;
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                if (command_arr[i].equals("U")) {
                    if (x - 1 < 0) {
                        graph[x][y] = "^";
                        continue;
                    }
                    if (graph[x-1][y].equals(".")) {
                        graph[x][y] = ".";
                        graph[x-1][y] = "^";
                        x--;
                        continue;
                    }
                    graph[x][y] = "^";
                } else if (command_arr[i].equals("D")) {
                    if (x + 1 >= H) {
                        graph[x][y] = "v";
                        continue;
                    }
                    if (graph[x+1][y].equals(".")) {
                        graph[x][y] = ".";
                        graph[x+1][y] = "v";
                        x++;
                        continue;
                    }
                    graph[x][y] = "v";
                } else if (command_arr[i].equals("L")) {
                    if (y - 1 < 0) {
                        graph[x][y] = "<";
                        continue;
                    }
                    if (graph[x][y-1].equals(".")) {
                        graph[x][y] = ".";
                        graph[x][y-1] = "<";
                        y--;
                        continue;
                    }
                    graph[x][y] = "<";
                } else if (command_arr[i].equals("R")) {
                    if (y + 1 >= W) {
                        graph[x][y] = ">";
                        continue;
                    }
                    if (graph[x][y+1].equals(".")) {
                        graph[x][y] = ".";
                        graph[x][y+1] = ">";
                        y++;
                        continue;
                    }
                    graph[x][y] = ">";
                } else if (command_arr[i].equals("S")) {
                    if (graph[x][y].equals(">")) {
                        for (int j = 1; j < W && y + j < W; j++) {
                            if (graph[x][y+j].equals("#")) {
                                break;
                            }
                            if (graph[x][y+j].equals("*")) {
                                graph[x][y+j] = ".";
                                break;
                            }
                        }
                    } else if (graph[x][y].equals("<")) {
                        for (int j = 1; j < W && y - j >= 0; j++) {
                            if (graph[x][y-j].equals("#")) {
                                break;
                            }
                            if (graph[x][y-j].equals("*")) {
                                graph[x][y-j] = ".";
                                break;
                            }
                        }
                    } else if (graph[x][y].equals("^")) {
                        for (int j = 1; j < W && x - j >= 0; j++) {
                            if (graph[x-j][y].equals("#")) {
                                break;
                            }
                            if (graph[x-j][y].equals("*")) {
                                graph[x-j][y] = ".";
                                break;
                            }
                        }
                    } else if (graph[x][y].equals("v")) {
                        for (int j = 1; j < W && x + j < H; j++) {
                            if (graph[x+j][y].equals("#")) {
                                break;
                            }
                            if (graph[x+j][y].equals("*")) {
                                graph[x+j][y] = ".";
                                break;
                            }
                        }
                    }
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
        }
    }
}
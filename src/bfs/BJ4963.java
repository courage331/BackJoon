package bfs;

import java.util.*;

public class BJ4963 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] chk;
    static int answer = 0;
    //12시 방향부터 시계방
    static int[] diry = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirx = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) {
                //종료조건
                break;
            }
            map = new int[m][n];
            chk = new boolean[m][n];
            answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!chk[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                    }
                }
            }
            System.out.println(answer);
        }

    }

    public static void dfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        chk[y][x] = true;
        answer++;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if (now_y >= 0 && now_y < m && now_x >= 0 && now_x < n) {
                    if (!chk[now_y][now_x] && map[now_y][now_x] == 1) {
                        queue.add(new Node(now_y, now_x));
                        chk[now_y][now_x] = true;
                    }
                }
            }

        }

    }
}



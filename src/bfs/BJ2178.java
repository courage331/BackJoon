package bfs;

import java.util.*;

public class BJ2178 {


    static int[][] map;
    static int[] diry = {0, 1, -1, 0};// 상 하 좌 우
    static int[] dirx = {1, 0, 0, -1}; //상 하 좌 우
    static boolean[][] chk;
    static int n;
    static int m;

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        chk = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        chk[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);

    }

    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if (0 <= now_y && now_y < n && 0 <= now_x && now_x < m) {
                    if (map[now_y][now_x] != 0 && !chk[now_y][now_x]) {

                        queue.add(new Node(now_y, now_x));
                        chk[now_y][now_x] = true;
                        map[now_y][now_x] = map[now.y][now.x] + 1;

                        for(int k=0; k<map.length; k++){
                            System.out.println(Arrays.toString(map[k]));
                        }
                        System.out.println("======================");
                    }
                }
            }
        }

    }
}

package bfs;

import java.util.*;

public class BJ10026 {

    static int n;
    static int m;
    static int normal;
    static int abnormal;

    static String[][] map;
    static boolean[][] chk;

    static int[] diry = {-1, 0, 1, 0};
    static int[] dirx = {0, 1, 0, -1};

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

        n = sc.nextInt();
        String[] line = new String[n];
        for (int i = 0; i < n; i++) {
            line[i] = sc.next();
        }
        m = line[0].length();
        map = new String[n][m];
        chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] value = line[i].split("");
            for (int j = 0; j < value.length; j++) {
                map[i][j] = value[j];
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!chk[i][j]) {
//                        System.out.println(i + " " + j);
                        bfs(i, j, k, map[i][j]);
                    }
                }
            }
            for (int p = 0; p < n; p++) {
                Arrays.fill(chk[p], false);
            }
        }
        System.out.println(normal + " " + abnormal);
//        System.out.println(Arrays.deepToString(map));
    }

    public static void bfs(int y, int x, int idx, String color) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        chk[y][x] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if (now_y >= 0 && now_y < n && now_x >= 0 && now_x < m) {
                    if (idx == 0) {
                        if (!chk[now_y][now_x] && map[now_y][now_x].equals(color)) {
                            queue.add(new Node(now_y, now_x));
                            chk[now_y][now_x] = true;
                        }
                    }else{
                        if(color.equals("R")||color.equals("G")){
                            color = "RG";
                        }
                        if (!chk[now_y][now_x] && color.contains(map[now_y][now_x])) {
                            queue.add(new Node(now_y, now_x));
                            chk[now_y][now_x] = true;
                        }
                    }
                }
            }
        }

        if (idx == 0) {
            normal++;
        } else {
            abnormal++;
        }
    }
}



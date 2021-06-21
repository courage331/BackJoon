package simulation;

import java.util.*;

public class BJ14503 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] chk;

    static int[] diry = {-1, 0, 1, 0, -1, 0, 1, 0};
    static int[] dirx = {0, 1, 0, -1, 0, 1, 0, -1};

    static int answer = 0;

    static class Node {
        int y;
        int x;
        int dir;

        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        chk = new boolean[n][m];

        int start_y = sc.nextInt();
        int start_x = sc.nextInt();
        int start_dir = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(start_y, start_x, start_dir);
        System.out.println(answer);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
    }

    public static void bfs(int y, int x, int dir) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, dir));
        //현재 위치를 청소한다.
        chk[y][x] = true;
        map[y][x] = 2;
        answer++;
        boolean checker = true;

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        while (!queue.isEmpty() && checker) {
            boolean checker2 = false;
//            System.out.println("=========================");
            Node now = queue.poll();
            //왼쪽으로 꺾음
            int now_dir = now.dir == 0 ? 3 : now.dir - 1;

            // 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
            //System.out.println(now.y+" "+now.x);
            for (int i = now_dir + 4; i > now_dir; i--) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];

                if (now_y >= 0 && now_y < n && now_x >= 0 && now_x < m) {
                    if (!chk[now_y][now_x] && map[now_y][now_x] == 0) {
                        // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//                        System.out.println(i + " : " + diry[i] + " " + dirx[i]);
//                        System.out.println(now_y + " " + now_x);
                        queue.add(new Node(now_y, now_x, i % 4));
                        answer++;
                        map[now_y][now_x] = 2;
                        chk[now_y][now_x] = true;
//                        for (int k = 0; k < n; k++) {
//                            System.out.println(Arrays.toString(map[k]));
//                        }
                        checker2 = true;
                        break;
                    } else {
                        //왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
                    }
                }
            }//for - end
            if(checker2){
                continue;
            }
//            네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//            네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

            switch (now.dir) {
                case 0:
                    now.y++;
                    if (map[now.y][now.x] == 1) {
                        checker = false;
                    } else {
                        queue.add(new Node(now.y, now.x, now.dir));
                    }
                    break;
                case 1:
                    now.x--;
                    if (map[now.y][now.x] == 1) {
                        checker = false;
                    } else {
                        queue.add(new Node(now.y, now.x, now.dir));
                    }
                    break;
                case 2:
                    now.y--;
                    if (map[now.y][now.x] == 1) {
                        checker = false;
                    } else {
                        queue.add(new Node(now.y, now.x, now.dir));
                    }
                    break;
                case 3:
                    now.x++;
                    if (map[now.y][now.x] == 1) {
                        checker = false;
                    } else {
                        queue.add(new Node(now.y, now.x, now.dir));
                    }
                    break;
            }
        }
    }
}


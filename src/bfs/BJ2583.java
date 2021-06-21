package bfs;

import java.util.*;

public class BJ2583 {

    static int m;
    static int n;
    static int[][] map;
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
        m = sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        map = new int[m][n];
        chk = new boolean[m][n];
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < k; i++) {
            //시작위치 [m][0]a
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            //System.out.println((m-y2)+" "+(y2-y1));
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
            //System.out.println(Arrays.deepToString(map));
        }
//        for(int i=0; i<m; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!chk[i][j] && map[i][j] == 0) {
                    answer++;
                    list.add(bfs(i, j));
                }
            }
        }
        System.out.println(answer);
        Collections.sort(list);
        String res = "";
        for(int i=0; i<list.size(); i++){
            res +=(list.get(i)+" ");
        }
        System.out.println(res.trim());

    }

    public static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        int answer = 1;
        queue.add(new Node(y, x));
        chk[y][x] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if(now_y>=0 && now_y<m && now_x>=0 && now_x<n){
                    if(!chk[now_y][now_x] && map[now_y][now_x]==0){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] = true;
                        answer++;
                    }
                }

            }
        }


        return answer;
    }
}



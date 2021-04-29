package bfs;

import java.util.*;

public class BJ7576 {

    static int[][] map;
    static boolean[][] chk;
    static int n;
    static int m;
    static int[] diry = {-1, 0, 1, 0}; //상 우 하 좌
    static int[] dirx = {0, 1, 0, -1};
    static Queue<Node> queue = new LinkedList<>();

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
        map = new int[m][n];
        chk = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                    chk[i][j] = true;
                }
            }
        }

        System.out.println( bfs(queue));
    }

    public static int bfs(Queue<Node> queue) {
        Queue<Node> q2 = new LinkedList<>();
        //System.out.println(queue.size());
        int answer = 0;
        boolean check = true;
        while (check) {
            while (!queue.isEmpty()) {
                Node now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int y = now.y + diry[j];
                    int x = now.x + dirx[j];
                    //System.out.println(y+":"+x);
                    if (y >= 0 && y < m && x >= 0 && x < n) {
                        if (!chk[y][x] && map[y][x] == 0) {
                            map[y][x] = 1;
                            q2.add(new Node(y, x));
                            chk[y][x] = true;
                        }
                    }
                }
            }
            //System.out.println(q2.toString());
            if(q2.size()==0){
                check = false;
            }else{
                while(!q2.isEmpty()){
                    queue.add(q2.poll());
                }
                answer++;
            }
            //System.out.println(Arrays.deepToString(map));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0){
                    answer=-1;
                    break;
                }
            }
            if(answer==-1){
                break;
            }
        }

        return answer;
    }
}


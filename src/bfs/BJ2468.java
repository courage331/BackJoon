package bfs;

import java.util.*;

public class BJ2468 {

    static int[][] map;
    static boolean[][] chk;
    static int temp =0;
    static int n;
    static int[] diry = {-1, 0, 1, 0}; //상 우 하 좌
    static int[] dirx = {0, 1, 0, -1};

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
        int answer =1;
        int minnum = Integer.MAX_VALUE;
        int maxnum = Integer.MIN_VALUE;
        n = sc.nextInt();
        map = new int[n][n];
        chk = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                minnum = Math.min(minnum, map[i][j]);
                maxnum = Math.max(maxnum, map[i][j]);
            }
        }
        for(int k=minnum; k<=maxnum; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j]<=k){
                        map[i][j]=0;
                    }
                }
            }
            for(int i=0; i<n; i++){
                Arrays.fill(chk[i], false);
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!chk[i][j] && map[i][j]!=0){
                        bfs(i,j);
                    }
                }
            }
            answer = Math.max(answer,temp);
            temp = 0;
        }

        System.out.println(answer);

    }

    public static void bfs(int y, int x){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y,x));
        chk[y][x]=true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<4; i++){
                int now_y = now.y+diry[i];
                int now_x = now.x+dirx[i];
                if(now_y>=0 && now_y<n && now_x>=0 && now_x<n){
                    if(!chk[now_y][now_x] && map[now_y][now_x]!=0){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] = true;
                    }
                }
            }
        }
        temp++;

    }
}


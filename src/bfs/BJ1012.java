package bfs;

import java.util.*;

public class BJ1012 {

    static int n;
    static int m;
    static int answer;
    static int [][] map;
    static boolean [][] chk;

    static int [] diry = {-1,0,1,0}; //상우하좌
    static int [] dirx = {0,1,0,-1};

    public static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i= 0; i<num; i++){
            answer =0;
            m = sc.nextInt();
            n = sc.nextInt();
            map = new int[n][m];
            chk = new boolean[n][m];
            int k = sc.nextInt();
            for(int j=0; j<k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] =1;
            }

            for(int p=0; p<map.length; p++){
                for(int q =0; q<map[p].length; q++){
                    if(!chk[p][q] && map[p][q]==1) {
                        bfs(p, q);
                        answer++;
                    }
                }
            }
            System.out.println(answer);

        }//큰 for

    }

    public static void bfs(int y, int x){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y,x));
        chk[y][x] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<4; i++){
                int now_y = now.y +diry[i];
                int now_x = now.x +dirx[i];
                if(now_y>=0 && now_y<n && now_x>=0 && now_x<m){
                    if(!chk[now_y][now_x] && map[now_y][now_x]==1){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] =true;
                    }
                }
            }
        }


    }
}

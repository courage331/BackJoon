package bfs;

import java.util.*;

public class BJ1743 {

    static int n;
    static int m;
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

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        chk = new boolean[n][m];
        int answer =0;
        int k = sc.nextInt();
        for(int i=0; i<k; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y-1][x-1] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!chk[i][j] && map[i][j]==1){
                    answer = Math.max(answer,bfs(i,j));
                }
            }
        }
        //System.out.println(Arrays.deepToString(map));
        System.out.println(answer);
    }

    public static int bfs(int y, int x){
        int answer =1;
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
                        chk[now_y][now_x]=true;
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

}


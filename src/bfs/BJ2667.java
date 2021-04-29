package bfs;

import java.util.*;

public class BJ2667 {

    static int [][] map;
    static boolean [][] chk;
    static int n;
    static int [] diry = {-1,0,1,0}; //상 우 하 좌
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

        String [] line = new String[n];
        map = new int[n][n];
        chk = new boolean[n][n];
        for(int i=0; i<n; i++){
            line[i] = sc.next();
        }
        sc.nextLine();
        for(int i=0; i<n; i++){
            String [] val = line[i].split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(val[j]);
            }
        }
        List<Integer> res = new ArrayList();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!chk[i][j] && map[i][j]==1){
                    res.add(bfs(i,j));
                }

            }
        }

        System.out.println(res.size());
        Collections.sort(res);
        for(int i =0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

    public static int bfs(int y, int x){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y,x));
        chk[y][x] = true;
        int answer = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            answer++;
            for(int i=0; i<4; i++){
                int now_y = now.y+diry[i];
                int now_x = now.x+dirx[i];
                if(now_y>=0 && now_y<n && now_x>=0 && now_x<n){
                    if(map[now_y][now_x]==1 && !chk[now_y][now_x]){
                        queue.add(new Node(now_y,now_x));
                        chk[now_y][now_x] = true;
                    }
                }
            }
        }



        return answer;
    }
}


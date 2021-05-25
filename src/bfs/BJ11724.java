package bfs;

import java.util.*;

public class BJ11724 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[] chk;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][n+1];
        chk = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y][x] = 1;
            map[x][y] = 1;
        }
        for (int i = 1; i <=n; i++) {
            if(!chk[i]){
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        answer++;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            chk[now] = true;
            for (int i =1; i <=n; i++) {
                if (!chk[i] && map[now][i] == 1 ) {
                    queue.add(i);
                    chk[i] = true;
                }
            }
        }
    }

}



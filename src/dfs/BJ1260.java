package dfs;

import java.util.*;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ1260 {

    static int [][] map;
    static boolean [] chkbfs;
    static boolean [] chkdfs;
    static int [] list;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int v = sc.nextInt();

        map = new int[n+1][n+1];

        chkbfs = new boolean[n+1];
        chkdfs = new boolean[n+1];


        for(int i=0; i<m; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();

            map[y][x]=1;
            map[x][y]=1;
        }

        list = new int[n];

        dfs(v);
        chkbfs[v] = true;
        System.out.println("");
        bfs(v);
    }

    public static void dfs(int v){
        System.out.print(v+" ");
        chkdfs[v]=true;
        for(int i=1; i<=n; i++){
            if(map[v][i]==1 && !chkdfs[i]){
                dfs(i);
            }
        }

    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            for(int i=1; i<=n; i++){
                if(map[temp][i]==1 && !chkbfs[i]){
                    queue.add(i);
                    chkbfs[i] = true;
                }
            }
        }


    }

}

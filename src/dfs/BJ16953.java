package dfs;

import java.util.*;

public class BJ16953 {

    static long m;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        m = sc.nextInt();

        dfs(n,1);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(long n,long res) {
        //System.out.println(n + " "+ res);
        if (n >= m) {
            if(n==m){
                answer = Math.min(res,answer);
            }
            return;
        }

        for(int i=0; i<2; i++){
            if(i==0){
                dfs(n*2,res+1);
            }else{
                dfs(n*10+1,res+1);
            }
        }


    }
}



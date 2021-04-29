package dp;

import java.util.*;

public class BJ10870 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        int [] dp = new int[21];
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<dp.length; i++){
            dp[i] = dp[i-1] +dp[i-2];
        }
        System.out.println(dp[n]);
    }

}

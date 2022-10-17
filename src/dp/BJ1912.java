package dp;

import java.util.*;

public class BJ1912 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long answer = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long[] dp = new long[n];
        dp[0] = arr[0];
        answer = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] +arr[i]);
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}



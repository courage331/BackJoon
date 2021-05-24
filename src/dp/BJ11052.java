package dp;

import java.util.*;

public class BJ11052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] deck = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            deck[i] = sc.nextInt();
        }
        dp[0] = 0;
        dp[1] = deck[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = deck[i];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}



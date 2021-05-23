import java.util.*;


public class Main {

    static int[] dp = new int[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = dp[1] * dp[1] + 1;//2
        dp[3] = dp[1] * dp[2] + dp[2] * dp[1] + 1 - 1; //4

        // dp[4] = 7
        //dp[5] = 13


        for (int i = 4; i <= 11; i++) {
            dp[i] += dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }


}


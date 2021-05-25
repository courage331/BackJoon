package simulation;

import java.util.*;

public class BJ20055 {

    static int n;
    static int k;
    static int[][] convey;
    static boolean[][] chk;
    static int answer = 0;
    static boolean checker = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        convey = new int[2][n];
        chk = new boolean[2][n];
        for (int j = 0; j < n; j++) {
            convey[0][j] = sc.nextInt();
        }

        for (int j = n - 1; j >= 0; j--) {
            convey[1][j] = sc.nextInt();
        }

        System.out.println(Arrays.deepToString(convey));

        while (checker) {
            working();
        }
        System.out.println(answer);
    }

    public static void working() {
        //1단계 시계방향으로 컨베이어 이동하며 로봇 떨구기


    }
}


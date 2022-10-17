package simulation;


import java.util.*;

public class BJ14499 {

    static int n;
    static int m;
    static int[][] map;
    static int starty;
    static int startx;
    static StringBuilder sb = new StringBuilder();
    /**
     *   2
     * 4 1 3
     *   5
     *   6
     */

    static int up = 0; // 위 (1)
    static int down = 0; // 아래 (6)
    static int forward = 0; //정면 (5)
    static int back = 0; //뒤 (2)
    static int right = 0; //우측 (3)
    static int left = 0; //좌측 (4)

    //동 서 북 남
    static int[] diry = {0, 0, -1, 1};
    static int[] dirx = {1, -1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        startx = sc.nextInt(); //세로
        starty = sc.nextInt(); //가로
        int num = sc.nextInt();
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < num; i++) {
            roll(startx, starty, sc.nextInt());
        }
        System.out.print(sb);
    }

    public static void roll(int y, int x, int pos) {
        //pos 동 서 북 남
        if(!(y + diry[pos - 1]>=0 && y + diry[pos - 1]<n && x + dirx[pos - 1]>=0 && x + dirx[pos - 1]<m)){
            return;
        }
        //이동
        startx = y + diry[pos - 1];
        starty = x + dirx[pos - 1];

        int temp = 0;
        int temp2 =0;
        int temp3 =0;

        switch (pos) {
            //동 -> 우측
            case 1:
                //right -> down
                temp = down;
                down = right;
                valChange();
                //down -> left
                temp2 = left;
                left = temp;//down

                //left -> up
                temp3 = up;
                up = temp2; //left

                //up -> right
                right = temp3;//up
                //forward -> forward
                //back -> back
                break;
            //서
            case 2:
                //forward -> forward
                //back -> back
                //left -> down
                temp = down;
                down = left;
                valChange();
                //down -> right
                temp2 = right;
                right = temp;
                //right -> up
                temp3 = up;
                up = temp2;
                //up -> left
                left = temp3;
                break;
            //북
            case 3:
                //left -> left
                //right -> right;

                //back -> down
                temp = down;
                down = back;
                valChange();
                //down -> forward
                temp2 = forward;
                forward = temp;
                //forward -> up
                temp3 = up;
                up = temp2;
                //up -> back
                back = temp3;
                break;
            //남
            case 4:
                //left -> left
                //right -> right;
                //forward -> down
                temp = down;
                down = forward;
                valChange();
                //down -> back
                temp2 = back;
                back = temp;

                //back -> up
                temp3 = up;
                up = temp2;

                //up -> forward
                forward = temp3;
                break;
        }
        sb.append(up+"\n");
    }

    public static void valChange(){
        //지도의 값이 0이 아니면 down(바닥면)에 값을 복사하고, 지도의 값은 0으로
        //지도의 값이 0이면 down(바닥면)에 있는 값을 지도에 복사한다.
        if(map[startx][starty]!=0){
            down = map[startx][starty];
            map[startx][starty]=0;
        }else{
            map[startx][starty] = down;
        }
    }
}



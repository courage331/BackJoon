package dfs;

import java.util.*;


public class BJ18430 {

    static int n;
    static int m;

    static int answer = 0;                         //0 2           0 3          1  3        1 2
    //부메랑 방향 1사분면(상,우) , 2사분면(상 좌), 3사분면(하 좌), 4사분(하 우)
    static int[][] dirk = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    static class Node {
        int y;
        int x;
        int type;

        public Node(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        public String toString(){
            return y+" , "+x+" == "+type+"/";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] chk = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();

            }
        }
        if (n == 1 || m == 1) {
            System.out.println(0);
        } else {

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
            dfs(0, 0, new ArrayList(), arr, chk);
//                }
//            }

            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x, List<Node> list, int[][] arr, boolean[][] chk) {
        //System.out.println(y + "!!!" + x);
        //System.out.println(Arrays.deepToString(chk));
        if (y == n && x == m) {
            //System.out.println("====================" + list.toString());
            int sum =0;
            for(int i=0; i<list.size(); i++){
                sum+=calc(list.get(i),arr);
                //System.out.println(sum);
            }

            answer = Math.max(answer,sum);
            return;
        }
        ArrayList<Node> newlist =  new ArrayList(list);
        for (int i = y; i < n; i++) {
            for (int j = x; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    //System.out.println(i+"중간"+j);
                    if (i + dirk[k][0] >= 0 && i + dirk[k][0] < n && j + dirk[k][1] >= 0 && j + dirk[k][1] < m) {
                        //System.out.println("1차통과");
                        if (!chk[i][j] && !chk[i + dirk[k][0]][j] && !chk[i][j + dirk[k][1]]) {
                            //System.out.println("2차통과");
                            newlist = new ArrayList(list);
                            chk[i][j] = true;
                            chk[i + dirk[k][0]][j] = true;
                            chk[i][j + dirk[k][1]] = true;
                            newlist.add(new Node(i,j , k+1));
                            //System.out.println(newlist.toString());
                            int now_y=i;
                            int now_x=j;
                            if(i==n-1 && j==m-1){
                                dfs(i+1,j+1,newlist,arr,chk);
                                newlist.remove(newlist.size() - 1);
                                chk[i][j] = false;
                                chk[i + dirk[k][0]][j] = false;
                                chk[i][j + dirk[k][1]] = false;
                            }else{
                                if (j != (m - 1)) {
                                    now_x++;
                                } else {
                                    now_x = 0;
                                    now_y++;
                                }
                                dfs(now_y, now_x, newlist, arr, chk);
                                newlist.remove(newlist.size() - 1);
                                chk[i][j] = false;
                                chk[i + dirk[k][0]][j] = false;
                                chk[i][j + dirk[k][1]] = false;
                            }


                        }


                    }//if문
                }//k-for


            }//j-for
        }//i-for
        dfs(n,m,newlist,arr,chk);

    }
    //return;

    public static int calc(Node node, int[][] arr){
        int res =0;
        int y = node.y;
        int x= node.x;
        int type = node.type;

        switch(type){
            case 1:
                res = arr[y][x]*2 + arr[y-1][x] + arr[y][x+1];
                break;
            case 2:
                res = arr[y][x]*2 + arr[y-1][x] + arr[y][x-1];
                break;
            case 3:
                res = arr[y][x]*2 + arr[y+1][x] + arr[y][x-1];
                break;
            case 4:
                res = arr[y][x]*2 + arr[y+1][x] + arr[y][x+1];
                break;
        }



        return res;
    }

}



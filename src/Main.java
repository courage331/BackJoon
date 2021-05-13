import java.util.*;


public class Main {

    static int n;
    static int m;

    static int answer = 0;                         //0 2           0 3          1  3        1 2
    static int[] dir = {1, 2, 3, 4}; //부메랑 방향 1사분면(상,우) , 2사분면(상 좌), 3사분면(하 좌), 4사분(하 우)
    static int[] diry = {-1, 1, 0, 0};//상하좌우
    static int[] dirx = {0, 0, 1, -1};
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
            return y+" , "+x+" == "+type;
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
        System.out.println(y + "!!!" + x);
        if (y == n && x == m) {
            System.out.println("====================" + list.toString());

            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = x; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.println(i+"중간"+j);
                    if (i + dirk[k][0] >= 0 && i + dirk[k][0] < n && j + dirk[k][1] >= 0 && j + dirk[k][1] < m) {
                        //System.out.println("1차통과");
                        if (!chk[i][j] && !chk[i + dirk[k][0]][j] && !chk[i][j + dirk[k][1]]) {
                            //System.out.println("2차통과");
                            ArrayList<Node> newlist = new ArrayList(list);
                            chk[i][j] = true;
                            chk[i + dirk[k][0]][j] = true;
                            chk[i][j + dirk[k][1]] = true;
                            newlist.add(new Node(i,j , k+1));
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


                    }
                }

            }
        }
    }
    //return;

}


package bruteforce;


import java.util.*;

public class BJ1759 {

    static int n;
    static int m;
    static String[] arr;
    static PriorityQueue<String> pq;
    static PriorityQueue<String> temp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new String[m];
        pq = new PriorityQueue<>();
        temp = new PriorityQueue<>();
        boolean [] chk = new boolean[m];


        for (int i = 0; i < m; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        dfs( 0,0,chk);
    }


    public static void dfs(int cnt, int idx, boolean [] chk) {
        //System.out.println(idx+" "+Arrays.toString(chk));
        if (cnt == n) {
            if (possible(chk)) {
                //System.out.println(Arrays.toString(chk));
                for(int i=0; i<m; i++){
                    if(chk[i]){
                        System.out.print(arr[i]);
                    }
                }
                System.out.println("");
            }
            return;
        }

        for (int i = idx; i < m; i++) {
            if (chk[i]) {
                continue;
            }
            chk[i] = true;
            dfs(cnt+1,i+1, chk);
            //System.out.println("=============");
            chk[i] = false;
        }
    }

    public static boolean possible(boolean [] chk){
        int mcnt = 0;
        int jcnt =0;
        for(int i=0; i<chk.length; i++){
            if(chk[i]){
                if ((arr[i]).equals("a") || (arr[i]).equals("e") || (arr[i]).equals("i") || (arr[i]).equals("o") || (arr[i]).equals("u")) {
                    mcnt++;
                } else {
                    jcnt++;
                }
            }
        }

        return mcnt>=1 && jcnt>=2 ? true : false;
    }
}


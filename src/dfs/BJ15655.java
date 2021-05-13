package dfs;

import java.util.*;


public class BJ15655 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] chk;
    static int[] list;
    static Map<String, Integer> chkmap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        chk = new boolean[n];
        list = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0);
    }

    public static void dfs(int idx) {

        if (idx == m) {
            String key = "";
            for(int i=0; i<chk.length; i++){
                key+=chk[i]+"";
            }

            if(!chkmap.containsKey(key)){
                for (int i = 0; i < m; i++) {
                    System.out.print(list[i] + " ");
                }
                System.out.println("");
                chkmap.put(key,0);
                return;
            }
            return;
        }


        for (int i = 0; i < n; i++) {
            if (chk[i]) {
                continue;
            }
            list[idx] = arr[i];
            chk[i] = true;
            dfs(idx + 1);
            chk[i] = false;
        }
    }
}


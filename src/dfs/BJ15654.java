package dfs;

import java.util.*;

public class BJ15654 {

    static int n;
    static int m;
    static int [] arr;
    static boolean [] chk;
    static int [] res;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        chk = new boolean[n];
        res = new int[m];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0);

    }

    public static void dfs(int idx){

        if(idx==m){
            for(int i=0; i<res.length;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println("");
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(chk[i]){
                continue;
            }
            res[idx]= arr[i];
            chk[i] = true;
            dfs(idx+1);
            chk[i] = false;
        }

    }
}


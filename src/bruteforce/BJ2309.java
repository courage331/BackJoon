package bruteforce;

import java.util.*;

public class BJ2309 {

    static int [] arr =new int[9];
    static boolean checker = true;
    static boolean [] chk = new boolean[9];
    static int [] list = new int[7];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        dfs(0,0);
    }
    public static void dfs(int sum, int idx){

        if(idx == 7){
            if(sum==100 && checker){
                Arrays.sort(list);
                for(int i=0; i<list.length; i++){
                    System.out.println(list[i]);
                }
                checker = false;
            }
            return;
        }

        for(int i=0; i<9; i++){
            if(chk[i]){
                continue;
            }
            sum += arr[i];
            chk[i] = true;
            list[idx] = arr[i];
            dfs(sum,idx+1);
            chk[i] = false;
            sum -= arr[i];
        }

    }

}


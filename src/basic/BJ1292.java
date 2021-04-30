package basic;

import java.util.*;

public class BJ1292 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr =new int[m+1];
        int len = arr.length;
        int cnt = 1;
        int cnt_count =0;
        int sum =0;
        for(int i=1; i<len; i++){
            arr[i] = cnt;
            cnt_count ++;
            if(cnt==cnt_count){
                cnt++;
                cnt_count=0;
            }

            if(i>=n && i<=m){
                sum+=arr[i];
            }
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(sum);
    }

}

package basic;

import java.util.*;

public class BJ2581 {

    static int [] arr;
    static int n;
    static int m;
    static int minnum = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m+1];
        int answer = findsosu();
        if(answer!=0){
            System.out.println(answer);
            System.out.println(minnum);
        }else{
            System.out.println(-1);
        }

    }

    public static int findsosu(){
        int sum=0;
        arr[0]=0;
        arr[1]=0;
        int len = arr.length;
        for(int i=2; i<len; i++){
            arr[i]=i;
        }

        for(int i=2; i<len; i++){
            if(arr[i]==0){
                continue;
            }else{
                if(arr[i]>=n && arr[i]<=m){
                    sum+=arr[i];
                    minnum = Math.min(minnum, arr[i]);
                }

            }
            for(int j=i+i; j<len; j+=i){
                arr[j]=0;
            }
        }
        //System.out.println(Arrays.toString(arr));
        return sum;
    }

}

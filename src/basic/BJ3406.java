package basic;

import java.util.*;

public class BJ3406 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            String binary = Integer.toBinaryString(k);
            //System.out.println(binary);
            for(int j=binary.length()-1; j>=0; j--){
                if(binary.substring(j,j+1).equals("1")){
                    System.out.print(binary.length()-1-j+" ");
                }
            }
            System.out.println();
        }

    }

}


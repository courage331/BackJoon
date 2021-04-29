package basic;

import java.util.*;

public class BJ2460 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int temp=0;
        int now=0;
        for(int i=0; i<10; i++){
            int down = sc.nextInt();
            int up = sc.nextInt();
            now += (up-down);
            temp = Math.max(temp, now);
            //System.out.println(i+" "+temp);
        }
        System.out.println(temp);
    }

}

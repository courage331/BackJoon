package basic;

import java.util.*;


public class BJ2920 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "";
        for(int i=0; i<8; i++){
            str+=sc.nextInt()+"";
        }
        if(str.equals("12345678")){
            System.out.println("ascending");
        }else if(str.equals("87654321")){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }

    }
}

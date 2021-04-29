package basic;

import java.util.*;

public class BJ2501 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<n/2; i++){
            if(n%i==0){
                map.put(i,0);
                map.put(n/i,0);
            }
        }
        if(map.size()<k){
            System.out.println("0");
        }else{
            List<Integer>result = new ArrayList<>();
            for(Map.Entry<Integer,Integer>entry : map.entrySet()){
                result.add(entry.getKey());
            }
            Collections.sort(result);
            //System.out.println(result.toString());
            System.out.println(result.get(k-1));
        }


    }

}


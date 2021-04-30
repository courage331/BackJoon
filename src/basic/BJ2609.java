package basic;

import java.util.*;

public class BJ2609 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int gcd = 1;

        Map<Integer,Integer> map = new HashMap();
        for(int i=1; i<=n/2; i++){
            if(n%i==0){
                map.put(i,0);
                map.put(n/i,0);
            }
        }
        List<Integer> nlist = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            nlist.add(entry.getKey());
        }
        Collections.sort(nlist,Collections.reverseOrder());
        int len = nlist.size();

        for(int i=0; i<len; i++){
            if(m%nlist.get(i)==0){
                gcd = nlist.get(i);
                break;
            }
        }
        //System.out.println(nlist.toString());
        int lcm = gcd * (n/gcd) * (m/gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }

}


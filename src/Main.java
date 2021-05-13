import java.util.*;

public class Main {

    static long n;
    static long m;
    static int answer= Integer.MAX_VALUE;
    static boolean chk = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nn = sc.next();
        String mm = sc.next();

        n = Long.parseLong(nn);
        m = Long.parseLong(mm);

        long temp = Long.parseLong(nn);
        int result  = 1;
        dfs(temp, result);

        System.out.println(chk ? -1 : answer);
    }

    public static void dfs(long temp, int result){
//        System.out.println(temp+" "+result);
        if(temp == m ){
//          System.out.println(temp+" "+result);
            answer = Math.min(answer,result);
            chk = false;
            return;
        }

        for(int i=0; i<2; i++){
            if(i==0){
                temp *=2;
                result+=1;

                if(temp>m){
                    continue;
                }

                dfs(temp, result);
            }else{
                temp = temp*10 +1;
                result +=1;
                if(temp>m){
                    continue;
                }
                dfs(temp,result);
            }

        }

    }
}

package dp;
import java.util.*;

public class BJ9251 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine()    ;
        String word2 = sc.nextLine();

        String [] temp1 = (" "+word1).split("");
        String [] temp2 = (" "+word2).split("");
        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
        int [][] lcs = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<lcs.length; i++){
            for(int j=0; j<lcs[0].length; j++){
                if(i==0 || j==0){
                    lcs[i][j]=0;
                }else if(temp1[i].equals(temp2[j])){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }

        System.out.println(lcs[word1.length()][word2.length()]);

    }
}



package greedy;

import java.util.*;

public class BJ1946 {

    static class Worker implements Comparable<Worker>{
        int paper;
        int interview;
        public Worker(int paper, int interview){
            this.paper = paper;
            this.interview =interview;
        }

        public int compareTo(Worker o){
            return paper-o.paper;
        }

        public String toString(){
            return "서류 : "+paper +" :: 인터뷰 : "+interview+"\n";
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=0; i<num; i++){
            int n = sc.nextInt();
            List<Worker> workerList = new ArrayList<>();
            int answer = n;
            for(int j=0; j<n; j++){
                workerList.add(new Worker(sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(workerList);
            //System.out.println(workerList.toString());
            int maxscore = workerList.get(0).interview;
            for(int j=1; j<n; j++) {
                if (workerList.get(j).interview > maxscore) {
                    answer--;
                }else{
                    maxscore = workerList.get(j).interview;
                }
            }
            System.out.println(answer);
        }

    }

}




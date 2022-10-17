package dfs;

import java.util.*;

public class BJ1083 {

    static int n;
    static Node[] tree;
    static boolean [] chk;
    static Map<Integer,Integer> map = new HashMap<>();
    static int k;
    static int answer =0;

    static class Node{
        int index;
        int prev;
        ArrayList<Integer> next;
        public Node(int index, int prev, ArrayList<Integer> next){
            this.index= index;
            this.prev = prev; //상위 노드
            this.next = next; //하위 노
        }
        public String toString(){
            return "index : "+index +" || prev : "+prev+" || next : "+next.toString();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new Node[n];
        chk = new boolean[n];
        int startIdx = 0;
        for(int i=0; i<n; i++){
            tree[i] = new Node(i,sc.nextInt(),new ArrayList<Integer>());
            if(tree[i].prev==-1){
                startIdx = i;
            }
        }
        k = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(tree[i].index == tree[j].prev){
                    tree[i].next.add(tree[j].index);
                }
            }
        }
        chk[k] = true;

        if(k==startIdx){
            System.out.println(0);
        }else{
            dfs(startIdx);
            System.out.println(answer==0 ? 1 : answer);
        }
    }

    public static void dfs(int idx){

        if(tree[idx].next.size()==0){// 자신이 마지막인지 체
            answer++;
            return;
        }

        for(int i=0; i<tree[idx].next.size(); i++){
            if(chk[tree[idx].next.get(i)]){
                if(tree[idx].next.size()==1){ //다음 node가 삭제된 상태에서, 자신이 마지막이 될것인지 체크하는 부분
                    answer++;
                }
                continue;
            }
            dfs(tree[idx].next.get(i));
        }

    }
}



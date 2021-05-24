import java.util.*;

public class Main {

    static int n;
    static int k;
    static int answer = Integer.MAX_VALUE;
    static Map<Integer,Integer> map = new HashMap();
    static class Node{
        int pos;
        int time;
        public Node(int pos, int time){
            this.pos=pos;
            this.time=time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if(n>k){
            System.out.println(n-k);
        }else{
            bfs(n,0);

        }
        System.out.println("정답 : "+answer);
    }

    public static void bfs(int idx, int time){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(idx,time));
        map.put(idx,0);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            System.out.println(now.pos+" "+now.time);
            if(now.pos>k){
                continue;
            }

            if(now.pos<0){
                continue;
            }

            if(now.pos==k){
                answer = Math.min(answer,now.time);
                continue;
            }

            if(!map.containsKey(now.pos+1)){
                queue.add(new Node(now.pos+1,now.time+1));
                map.put(now.pos+1,now.time+1);
            }else{
                if(map.get(now.pos+1)>now.time+1){
                    queue.add(new Node(now.pos+1,now.time+1));
                    map.put(now.pos+1,now.time+1);
                }
            }

            if(!map.containsKey(now.pos-1)){
                queue.add(new Node(now.pos-1,now.time+1));
                map.put(now.pos-1,now.time+1);
            }else{
                if(map.get(now.pos-1)>now.time+1){
                    queue.add(new Node(now.pos-1,now.time+1));
                    map.put(now.pos-1,now.time+1);
                }
            }

            if(!map.containsKey(now.pos*2)){
                queue.add(new Node(now.pos*2,now.time+1));
                map.put(now.pos*2,now.time+1);
            }else{
                if(map.get(now.pos*2)>now.time+1){
                    queue.add(new Node(now.pos*2,now.time+1));
                    map.put(now.pos*2,now.time+1);
                }
            }

        }

    }
}


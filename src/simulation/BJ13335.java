package simulation;

import java.util.*;

public class BJ13335 {

    static int n; //트럭 개수
    static int w; //다리 길
    static int l; //최대하중 트럭 무게의 합보다 크거나 같아야한다.
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        l = sc.nextInt();
        int maxweight = 0;
        Queue<Integer> wait_trucks = new LinkedList<>();
        Queue<Integer> bridge_weight = new LinkedList<>();
        List<Integer> bridge = new ArrayList<>();
        int arrive_trucks = 0;
        for (int i = 0; i < n; i++) {
            wait_trucks.add(sc.nextInt());
        }

        while (arrive_trucks != n) {
            time++;
//            System.out.println(time);

            if (bridge.size() != 0) {
                for (int i = 0; i < bridge.size(); i++) {
                    bridge.set(i, bridge.get(i) + 1);
                }

                if (bridge.get(0) > w) {
                    bridge.remove(0);
                    arrive_trucks++;
                    maxweight -= bridge_weight.poll();
                }

            }

            if (!wait_trucks.isEmpty()) {
                if (maxweight + wait_trucks.peek() <= l) {
                    bridge.add(1);
                    bridge_weight.add(wait_trucks.peek());
                    maxweight += wait_trucks.poll();
                }
            }
//            System.out.println(wait_trucks.toString());
//            System.out.println(bridge.toString());
        }
        System.out.println(time);
    }
}



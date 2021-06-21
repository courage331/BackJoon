package greedy;

import java.util.*;

public class BJ2802 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String num = sc.next();

        Deque<Character> dq = new ArrayDeque<>();
        char[] arr = num.toCharArray();
        dq.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (k > 0 && !dq.isEmpty() && dq.peekLast() < arr[i]) {
                dq.removeLast();
                k--;
            }
            dq.add(arr[i]);


        }
        StringBuffer sb = new StringBuffer();
        while (dq.size() > k) {
            sb.append(dq.pollFirst());
        }
        System.out.println(sb.toString());
    }
}



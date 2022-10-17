package simulation;

import java.util.*;

public class BJ3190 {

    static int n;
    static int[][] map;
    static boolean[][] chk;

    static int[] diry = {-1, 0, 1, 0};
    static int[] dirx = {0, 1, 0, -1};
    static Map<Integer, String> dirmap = new HashMap();
    static List<Node> history = new ArrayList();

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        chk = new boolean[n][n];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            dirmap.put(sc.nextInt(), sc.next());
        }
        System.out.println(gamestart(0, 0));
    }

    public static int gamestart(int y, int x) {
        int answer = 0;
        int dir = 1; //우측으로 시작
        int bodylen = 1;
        Node head = new Node(y, x);
        history.add(new Node(y, x));
        while (true) {
            answer++;
            head.y = diry[dir] + head.y;
            head.x = dirx[dir] + head.x;

            //머리가 범위를 벗어난 경우에 종료
            if (!(head.y > -1 && head.y < n && head.x > -1 && head.x < n)) {
                break;
            }

            //현재 몸통의 위치 최신화
            for (int i = 0; i < n; i++) {
                Arrays.fill(chk[i], false);
            }
            for (int i = 0; i < bodylen; i++) {
                chk[history.get(history.size() - 1 - i).y][history.get(history.size() - 1 - i).x] = true;
            }

            //머리가 몸통에 닿으면 종료, 아닌경우에는 이동경로에 현재위치를 남긴다.
            if (chk[head.y][head.x]) {
                break;
            } else {
                history.add(new Node(head.y, head.x));
            }

            //사과 먹기
            if (map[head.y][head.x] == 1) {
                map[head.y][head.x] = 0;
                bodylen++;
            }

            //방향전환
            if (dirmap.containsKey(answer)) {
                if (dirmap.get(answer).equals("L")) { //왼쪽 -> 반시계 방향
                    dir = dir - 1 == -1 ? 3 : dir - 1;
                } else {
                    dir = dir + 1 == 4 ? 0 : dir + 1;
                }
            }
        }
        return answer;
    }
}



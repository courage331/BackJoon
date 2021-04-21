import java.util.*;

public class Main {


	static int [][] map;
	static int [] diry = {0,1,-1,0};// 상 하 좌 우
	static int [] dirx = {1,0,0,-1}; //상 하 좌 우
	static boolean [][] chk;
	static int maxAnswer = Integer.MAX_VALUE;
	static int n;
	static int m;

	public static class Node{
		int y;
		int x;

		public Node(int y, int x){
			this.y=y;
			this.x=x;
		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		//sc.nextLine();
		map = new int[n][m];
		chk = new boolean[n][m];
		int answer=1;

		for(int i=0; i<n; i++){
//			String line = sc.nextLine();
			String line = sc.next();
			for(int j=0; j<line.length(); j++){
				map[i][j]=Integer.parseInt(line.substring(j,j+1));
			}
		}

		bfs(0,0,answer);
		System.out.println(map[n-1][m-1]);
//		System.out.println(Arrays.deepToString(map));

	}

	public static void bfs(int y, int x, int answer){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(y,x));
		chk[0][0] = true;
		while(!queue.isEmpty() || (y==n && x==m) ) {
			Node now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int now_y = now.y + diry[i];
				int now_x = now.x + dirx[i];
				if (0 <= now_y && now_y < n && 0 <= now_x && now_x < m) {
					if (map[now_y][now_x] !=0 && !chk[now_y][now_x]) {
						queue.add(new Node(now_y, now_x));
						chk[now_y][now_x] = true;
						map[now_y][now_x] = map[now.y][now.x]+1;
					}
				}
			}
		}

		return;
	}
}

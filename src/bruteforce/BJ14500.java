package bruteforce;

import java.util.*;

public class BJ14500 {

    static int n;
    static int m;
    static int map[][];
    //정사각형
    static int[][] shape0 = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    //  ㅡ
    static int[][] shape1 = {{0, 0}, {0, 1}, {0, 2}, {0, 3}};
    // ㅣ
    static int[][] shape2 = {{0, 0}, {1, 0}, {2, 0}, {3, 0}};

    //ㅗ
    static int[][] shape3 = {{0, 0}, {1, -1}, {1, 0}, {1, 1}};

    // ㅏ
    static int[][] shape4 = {{0, 0}, {1, 0}, {2, 0}, {1, 1}};

    // ㅜ
    static int[][] shape5 = {{0, 0}, {0, 1}, {0, 2}, {1, 1}};

    // ㅓ
    static int[][] shape6 = {{0, 0}, {1, 0}, {2, 0}, {1, -1}};

    //ㄴ
    //ㄱ
    static int[][] shape7 = {{0, 0}, {1, 0}, {1, 1}, {2, 1}};
    static int[][] shape8 = {{0, 0}, {1, 0}, {1, -1}, {2, -1}};
    static int[][] shape9 = {{0, 0}, {0, 1}, {1, 1}, {1, 2}};
    static int[][] shape10 = {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}};

    // ㄱ
    static int[][] shape11 = {{0, 0}, {0, 1}, {0, 2}, {1, 2}};
    static int[][] shape12 = {{0, 0}, {0, 1}, {0, 2}, {-1, 2}};

    static int[][] shape13 = {{0, 0}, {-1, 0}, {-2, 0}, {-2, 1}};
    static int[][] shape14 = {{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}};

    static int[][] shape15 = {{0, 0}, {0, -1}, {0, -2}, {1, -2}};
    static int[][] shape16 = {{0, 0}, {0, -1}, {0, -2}, {-1, -2}};

    static int[][] shape17 = {{0, 0}, {1, 0}, {2, 0}, {2, 1}};
    static int[][] shape18 = {{0, 0}, {1, 0}, {2, 0}, {2, -1}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        int answer = 0;
        List<int[][]> arr = new ArrayList<>();
        arr.add(shape0);
        arr.add(shape1);
        arr.add(shape2);
        arr.add(shape3);
        arr.add(shape4);
        arr.add(shape5);
        arr.add(shape6);
        arr.add(shape7);
        arr.add(shape8);
        arr.add(shape9);
        arr.add(shape10);
        arr.add(shape11);
        arr.add(shape12);
        arr.add(shape13);
        arr.add(shape14);
        arr.add(shape15);
        arr.add(shape16);
        arr.add(shape17);
        arr.add(shape18);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int k = 0; k < arr.size(); k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i + arr.get(k)[1][0] >= 0 && i + arr.get(k)[1][0] < n &&
                            i + arr.get(k)[2][0] >= 0 && i + arr.get(k)[2][0] < n &&
                            i + arr.get(k)[3][0] >= 0 && i + arr.get(k)[3][0] < n &&
                            j + arr.get(k)[1][1] >= 0 && j + arr.get(k)[1][1] < m &&
                            j + arr.get(k)[2][1] >= 0 && j + arr.get(k)[2][1] < m &&
                            j + arr.get(k)[3][1] >= 0 && j + arr.get(k)[3][1] < m) {

//                        System.out.println(map[i][j]);
//                        System.out.println(map[i + arr.get(k)[1][0]][j + arr.get(k)[1][1]]);
//                        System.out.println(map[i + arr.get(k)[2][0]][j + arr.get(k)[2][1]]);
//                        System.out.println(map[i + arr.get(k)[3][0]][j + arr.get(k)[3][1]]);

                        int sum = map[i][j] + map[i + arr.get(k)[1][0]][j + arr.get(k)[1][1]] + map[i + arr.get(k)[2][0]][j + arr.get(k)[2][1]] + map[i + arr.get(k)[3][0]][j + arr.get(k)[3][1]];
                        answer = Math.max(answer, sum);
                    }


                }
            }
        }
        System.out.println(answer);
        System.out.println("A C D".split(" ").length);
    }
}


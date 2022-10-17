//import java.util.*;
//
//public class Main {
//
//    //    static int[] arr;
//    static List<Integer>arr;
//    static boolean[] chk;
//    static int n;
//    static boolean check = false;
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int k = sc.nextInt();
//        long idx = 0;
////        arr = new int[n];
//        arr = new ArrayList<>();
//        chk = new boolean[n+1];
//        for (int i = 0; i < n; i++) {
////            arr[i] = i + 1;
//            arr.add(i+1);
//        }
//        int[] input = new int[n];
//        if (k == 1) {
//            idx = sc.nextLong();
//            case1(idx, new ArrayList<Integer>());
//        } else {
//            for (int i = 0; i < n; i++) {
//                input[i] = sc.nextInt();
//            }
//            case2(input);
//        }
//
//
//    }
//
//    public static void case1(long idx, ArrayList<Integer> input) {
//
//        if (input.size() == n) {
//            for (int i = 0; i < n; i++) {
//                System.out.print(input.get(i) + " ");
//            }
//            return;
//        }
//        long target = multipleMaxNum(n - 1 - input.size());
//
//        int pos = Integer.parseInt(String.valueOf((idx / target)));
//        if(idx%target==0){
//            pos--;
//        }
////        System.out.println(idx/target);
//        System.out.println("idx : "+idx);
//        System.out.println("target : "+target);
//        System.out.println("pos : "+pos);
//        System.out.println("input : "+input);
//        System.out.println("arr : "+arr);
//        System.out.println(Arrays.toString(chk));
//        idx -= target*(pos);
//        if(chk[arr.get(pos)]){
//            System.out.println("if arr : " + arr +" pos : "+pos+" data : "+arr.get(pos));
//            //값 바꾸기
//            while(true){
//                pos++;
//                if(pos==arr.size()){
//                    pos=0;
//                }
//
//                if(!chk[arr.get(pos)]) {
//                    chk[arr.get(pos)] = true;
//                    input.add(arr.get(pos));
//                    arr.remove(pos);
//                    case1(idx, input);
//                    check = true;
//                    return;
//                }
//                if(check){
//                    return;
//                }
//            }
//        }else{
//            //사용안함 경우
//            System.out.println("else arr : " + arr +" pos : "+pos+" data : "+arr.get(pos));
//            chk[pos] = true;
//            input.add(arr.get(pos));
//            arr.remove(pos);
//            case1(idx,input);
//        }
//        return;
//    }
//
//    public static void case2(int [] input) {
//        long res = 0;
//        for(int i=0; i<input.length; i++){
//            long target = multipleMaxNum(n - 1 - i);
//            target = target*
//        }
//
//    }
//
//    public static long multipleMaxNum(int num) {
//        long result = 1;
//        for (int i = 1; i <= num; i++) {
//            result *= i;
//        }
//
//        return result;
//    }
//}
import java.util.*;


public class Main {


    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);

        Set<String> set = new HashSet<>();
        set.add("11");
        set.add("3");
        set.add("x");
        set.add("22");
        set.add("41");
        set.add("14");
        set.add("c");

        Set<String>set2 = new HashSet<>();
//        set2.add("cc");
        set2.add("14");
        set2.add("3");
        set2.add("11");
        for(String i : set){
            System.out.println(i);
        }

        System.out.println(set.containsAll(set2));

        for(int i=0; i<10; ++i){
            System.out.println(i);
        }

        System.out.println("=========");
        for(int i=0; i<10; i++){
            System.out.println(i);
        }

    }
}

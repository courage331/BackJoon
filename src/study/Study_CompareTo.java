package study;

import java.util.*;

class Test implements Comparable<Test>{

    int first;
    int second;
    int third;

    public Test(int first, int second, int third){
        this.first=first;
        this.second= second;
        this.third = third;

    }

    public int compareTo(Test o){
//        if(third>o.third){
//            return -1;
//        }else{
//            return 1;
//        }
        return first - o.first;
    }

    public String toString(){
        return "first : "+first+", second : "+second+", third : "+third;
    }

}

public class Study_CompareTo {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Test> arr = new ArrayList();

        for(int i=0; i<10; i++){
            arr.add(new Test(i,10-i,(int)(Math.random()*100)));
        }
        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println("========================");
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}


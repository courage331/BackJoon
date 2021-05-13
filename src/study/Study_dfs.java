package study;

import java.util.*;

class Study_dfs {

    static ArrayList<HashSet<Integer>> candidateKey;

    public static void main(String[] args){
        String [][] relation ={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        candidateKey = new ArrayList<>();
        int colSize = relation[0].length;

        for(int i = 1 ; i <= colSize ; ++i) {
            makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
        }

        System.out.println("결과 값 : " +candidateKey.size());
    }

    static public void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
        if(idx == size) {

            //for(int i : keySet) System.out.print(i + " ");

            for(HashSet<Integer> key : candidateKey) {
                System.out.println("key : "+key.toString() + " keyset : "+ keySet.toString());
                if(keySet.containsAll(key)) {
                    System.out.println("는 " + key + "를 포함합니다.");
                    return;
                }
            }

            if(isUnique(keySet, relation)) {
               // System.out.println("는 후보키 입니다.");
                candidateKey.add(keySet);
                System.out.println(candidateKey.toString());
            } else {
                //System.out.println("는 후보키가 아닙니다.");
            }


            return;
        }

        for(int i = attr + 1 ; i <= maxAttr ; ++i) {
            HashSet<Integer> newKeySet = new HashSet<>(keySet);
            newKeySet.add(i);
            makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
        }
    }

    static public boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println("isUnique() : " + keySet.toString());
        for(int r = 0 ; r < relation.length ; r++) {
            String key = "";

            for(int c : keySet) {
                key += relation[r][c];
            }

            if(map.containsKey(key)) return false;
            else map.put(key, key);
        }
        return true;
    }
}

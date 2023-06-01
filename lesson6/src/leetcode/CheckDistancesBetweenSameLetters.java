package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckDistancesBetweenSameLetters {

    public static boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            map.computeIfPresent(s.charAt(i) - 'a', (key,val) -> val= index-val);
            map.putIfAbsent(s.charAt(i) - 'a', index);
        }

        for (Map.Entry<Integer, Integer> elem: map.entrySet()){
            if(distance[elem.getKey()] != (elem.getValue() -1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}

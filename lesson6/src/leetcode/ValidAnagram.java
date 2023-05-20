package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            map.computeIfPresent(s.charAt(i) - 'a', (key,val) -> val+=1);
            map.putIfAbsent(s.charAt(i) - 'a', 1);
            map.computeIfPresent(t.charAt(i) - 'a', (key,val) -> val-=1);
            map.putIfAbsent(t.charAt(i) - 'a', -1);
        }

        return map.values().stream().allMatch(val -> val == 0);

    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res ^ s.charAt(i) - 'a';
            res = res ^ t.charAt(i) - 'a';
        }

        return res == 0;

    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));

    }
}

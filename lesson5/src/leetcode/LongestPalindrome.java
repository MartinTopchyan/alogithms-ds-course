package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Integer, Integer> map = new HashMap<>(58);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.computeIfPresent(c-65, (key,val) -> val +1);
            map.putIfAbsent(c-65, 1);
        }
        boolean hasEven = false;

        int res = 0;
        for (Integer val : map.values()){
            res+= val/2 *2;
            if(val%2 ==1){
                hasEven = true;
            }
        }
        if(hasEven){
            res+=1;
        }
        return res;
    }
}

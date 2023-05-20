package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 1;
        while (right < s.length()) {
            Character c = s.charAt(right);
            while (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            }
            map.put(c, right);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;

    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 1;
        while (right < s.length()) {
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c));
            }
            map.put(c, right+1);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("dvdf"));

    }

}

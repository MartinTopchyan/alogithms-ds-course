package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {
    public static int firstUniqChar(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a'] +=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(frequency[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }


}

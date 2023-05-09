package leetcode;

import java.util.Stack;

public class RemovingStarsFromString {

    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> cha = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '*') {
                cha.push(ch);
            } else {
                cha.pop();
            }
        }
        cha.forEach(builder::append);
        return builder.toString();
    }

    public String removeStars2(String s) {

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                s = s.substring(0, i-1) + s.substring(i + 1);
            }
        }
        return s;
    }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (slow != fast || fast != 1){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast ==1;
    }

     static int getNext(int n){
        int sum = 0;
        while (n > 0){
            int tmp = n % 10;
            sum += Math.pow(tmp, 2);
            n = n /10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}

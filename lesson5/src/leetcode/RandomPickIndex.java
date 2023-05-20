package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {

    private final int[] numsArr;
    private final Random random;
    public RandomPickIndex(int[] nums) {
        numsArr = nums;
        random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numsArr.length; i++) {
            if(numsArr[i] == target){
                list.add(i);
            }
        }

        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        new RandomPickIndex(new int[]{});
    }
}

import java.util.Arrays;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int oddIndex = 0;
        int evenIndex = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[oddIndex] = num;
                oddIndex += 2;
            } else {
                res[evenIndex] = num;
                evenIndex += 2;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

}

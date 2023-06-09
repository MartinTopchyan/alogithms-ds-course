import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0){
            return;
        }

        int n = nums.length -1;
        reverse(nums, 0, n);
        reverse(nums, 0, k-1);
        reverse(nums, k, n);
    }

    public void reverse(int[] nums, int left, int right){
        while (left< right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}

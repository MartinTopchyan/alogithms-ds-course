package leetcode;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int index = 0;
        while (index <= right){
            if(nums[index]==0){
                swap(nums, left, index);
                left++;
                index++;
            }else if(nums[index] == 2){
                swap(nums, right, index);
                right--;
            }else index++;

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,1});
    }

    /// [2,0,2,1,1,0]
}

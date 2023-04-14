import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k =1;
        for(int i =1; i< nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[k++] = nums[i];
            }

        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2}));
    }
}

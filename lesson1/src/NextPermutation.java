import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean needsToBeReversed = true;
        for(int i = n-1; i > 0 ; i-- ){
            if(nums[i] > nums[i-1]){
                needsToBeReversed = false;
                int swapIndex = this.nextMax(nums, i, nums[i-1]);
                if(swapIndex >= 0){
                    int current = nums[i-1];
                    nums[i-1] = nums[swapIndex];
                    nums[swapIndex] = current;
                }
                this.revers(nums, i, n -1);
                break;
            }
        }
        if(needsToBeReversed){
            this.revers(nums, 0, nums.length-1);
        }
        System.out.println(Arrays.toString(nums));
    }

    void revers(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int current = nums[i];
            nums[i] = nums[j];
            nums[j] = current;
        }
    }

    int nextMax(int[] nums, int start, int key){
        int index = -1;
        while(start < nums.length && nums[start] > key){
            index = start;
            start++;
        }
        return index;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2, 4, 3, 4});
    }
}

public class FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
//        if(nums.length == 1){
//            return 0;
//        }
        int leftMostIndex = -1;

        int right = nums.length -1;
        for (int i = 0; i <= right ; i++){
            int leftSum = sum(nums, 0, i-1);
            int rightSum = sum(nums, i+1, right);
            if(leftSum == rightSum){
                leftMostIndex = i;
            }

        }
        return leftMostIndex;
    }

    public int sum(int[]nums, int first, int last){
        int sum = 0;
        for(int i = first; i <= last; i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheMiddleIndexInArray().findMiddleIndex(new int[]{0,0,0,0}));
    }
}

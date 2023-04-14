public class FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int gcd = 1;
        for(int i = 2; i <= min; i++){
            if(min % i == 0 && max %i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(new FindGreatestCommonDivisorOfArray().findGCD(new int[]{3,3}));
    }
}

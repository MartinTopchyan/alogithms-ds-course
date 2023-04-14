import java.util.Arrays;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int index =0;
        for(int i = 0, j = n; i < n; i++,j++){
            res[index++] = nums[i];
            res[index++] = nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
    }
}

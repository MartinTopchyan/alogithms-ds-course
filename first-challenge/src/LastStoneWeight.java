import java.util.Arrays;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        if (stones.length == 0) {
            return 0;
        }

        Arrays.sort(stones);
        int index = stones.length - 1;

        if (stones[index] == stones[index - 1]) {
            return lastStoneWeight(Arrays.copyOfRange(stones, 0, index-1));
        } else {
            int[] arr = Arrays.copyOfRange(stones, 0, index);
            arr[index - 1] = Math.abs(stones[index] - stones[index - 1]);
            return lastStoneWeight(arr);
        }
    }

    // [2,7,4,1,8,1]

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{1, 1}));
    }

}

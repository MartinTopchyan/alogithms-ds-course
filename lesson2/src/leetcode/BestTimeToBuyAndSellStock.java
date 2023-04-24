package leetcode;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length){
            int profit = prices[right] - prices[left];
            if(profit < 0){
                left = right;
            }else {
                if(maxProfit < profit){
                    maxProfit = profit;
                }
            }
            right++;

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

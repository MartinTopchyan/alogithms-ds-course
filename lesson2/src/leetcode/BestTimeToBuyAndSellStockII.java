package leetcode;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length){
            int profit = prices[right] - prices[left];
            if(profit > 0){
                maxProfit += profit;
            }
            left=right;
            right++;

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}

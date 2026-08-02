class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE;
        int sell = -1;
        int max_profit = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(buy > prices[i]) {
                buy = prices[i];
            }
            else {
                sell = prices[i];
                max_profit = Math.max(max_profit, sell-buy);
            }
        }

        return max_profit == Integer.MIN_VALUE ? 0 : max_profit;
    }
}

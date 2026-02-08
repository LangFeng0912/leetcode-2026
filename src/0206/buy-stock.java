class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;

        while(i<prices.length-1){
            int cur = 0;
            int j = i;
            while((j<prices.length-1) && (prices[j+1] > prices[j])){
                cur += (prices[j+1] - prices[j]);
                j++;
            }
            maxProfit += cur;
            i = Math.max(i+1, j);
        }

        return maxProfit;
    }
}
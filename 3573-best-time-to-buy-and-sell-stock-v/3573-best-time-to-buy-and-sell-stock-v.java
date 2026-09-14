class Solution {
    public long findProfit(int i, int []prices, int k, int flag, long [][][]dp){

        if(i == prices.length){
            if(flag == 2){
                return 0;
            }
            return (long)-1e15;
        }

        if(k == 0){
            return 0;
        }

        if(dp[i][k][flag] != Long.MIN_VALUE){
            return dp[i][k][flag];
        }

        long profit1 = 0;
        long profit2 = 0;
        long profit3 = 0;
        if(flag == 2){
            profit1 = -prices[i]+findProfit(i+1, prices, k, 1, dp);
            profit2 = prices[i]+findProfit(i+1, prices, k, 0, dp);
            profit3 = findProfit(i+1, prices, k, flag, dp);
        }
        else if(flag == 0){
            long profit4 = -prices[i]+findProfit(i+1, prices, k-1, 2, dp);
            long profit5 = findProfit(i+1, prices, k, flag, dp);
            return dp[i][k][flag] = Math.max(profit4, profit5);
        }
        else if(flag == 1){
            long profit4 = prices[i]+findProfit(i+1, prices, k-1, 2, dp);
            long profit5 = findProfit(i+1, prices, k, flag, dp);
            return dp[i][k][flag] = Math.max(profit4, profit5);
        }

        return dp[i][k][flag] = Math.max(profit1, Math.max(profit2, profit3));
    }
    public long maximumProfit(int[] prices, int k) {
        long [][][]dp = new long[prices.length][k+1][3];

        for(long [][]r:dp){
            for(long []c:r){
                Arrays.fill(c, Long.MIN_VALUE);
            }
        }
        return findProfit(0, prices, k, 2, dp);
    }
}
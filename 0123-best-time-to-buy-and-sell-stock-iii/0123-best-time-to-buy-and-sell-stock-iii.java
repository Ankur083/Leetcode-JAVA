class Solution {
    public int maxProfitTrans(int ind, int []prices, int buy, int k, int [][][]dp){

        if(k >= 2){
            return 0;
        }

        if(ind >= prices.length){
            return 0;
        }

        if(dp[ind][buy][k] != -1){
            return dp[ind][buy][k];
        }


        if(buy == 1){
            int buyStock = -prices[ind]+maxProfitTrans(ind+1, prices, 0, k, dp);
            int skipBuy = maxProfitTrans(ind+1, prices, 1, k, dp);

            return dp[ind][buy][k] = Math.max(buyStock, skipBuy);
        }
        else{
            int sellStock = prices[ind]+maxProfitTrans(ind+1, prices, 1, k+1, dp);
            int skipSell = maxProfitTrans(ind+1, prices, 0, k, dp);

            return dp[ind][buy][k] = Math.max(sellStock, skipSell);
        }
    }
    
    public int maxProfit(int[] prices) {
        int [][][]dp = new int[prices.length][2][2];

        for(int [][]rows:dp){
            for(int []r:rows){
                Arrays.fill(r, -1);
            }
        }
        return maxProfitTrans(0, prices, 1, 0, dp);
    }
}
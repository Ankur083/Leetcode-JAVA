class Solution {
    public int find(int i, int amount, int []coins, int [][]dp){

        if(amount == 0){
            return 0;
        }

        if(i >= coins.length || amount < 0){
            return (int)1e9;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = 1+find(i,  amount-coins[i], coins, dp);
        int noTake = find(i+1, amount, coins, dp);

        return dp[i][amount] = Math.min(take, noTake);
    }
    public int coinChange(int[] coins, int amount) {

        int [][]dp = new int[coins.length][amount+1];

        for(int []r:dp){
            Arrays.fill(r, -1);

        }
        int ans = find(0, amount, coins, dp);

        if(ans >= 1e9){
            return -1;
        }
        return ans;
    }
}
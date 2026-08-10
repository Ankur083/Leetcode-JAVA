class Solution {
    public int findMinCost(int i, int []cost, int[]dp){

        if(i >= cost.length){
            return 0;
        }
        if(i == cost.length-1){
            return cost[i];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int oneStepCost = cost[i] + findMinCost(i+1, cost, dp);
        int twoStepCost = cost[i]+findMinCost(i+2, cost, dp);


        return dp[i] = Math.min(oneStepCost, twoStepCost);
    }
    public int minCostClimbingStairs(int[] cost) {

        int []dp = new int [cost.length];
        Arrays.fill(dp, -1);

        return Math.min(findMinCost(0, cost, dp), findMinCost(1, cost, dp));
    }
}
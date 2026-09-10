class Solution {
    public int findWays(int i, int n, int []dp){

        if(i == n) return 1;
        if(i > n) return 0;

        if(dp[i] != -1){
            return dp[i];
        }

        int oneStep = findWays(i+1, n, dp);

        int twoStep = 0;
        if(i+2 <= n){
            twoStep = findWays(i+2, n, dp);
        }

        return dp[i] = oneStep+twoStep;
    }

    public int climbStairs(int n) {
        int []dp = new int[n+1];

        Arrays.fill(dp, -1);
        return findWays(0, n, dp);
    }
}
class Solution {
    public int find(int i, int target, int []costs, int []dp){

        if(i == target){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }

       for(int jump = 1; jump <= 3; jump++){

            int j = i+jump;

            if(j <= target){
                int cost = costs[j-1]+jump*jump+find(j, target, costs, dp);
                ans = Math.min(cost, ans);
            }

       }

        return dp[i] = ans;
    }
    public int climbStairs(int n, int[] costs) {

        int []dp = new int[costs.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        
        return find(0, n, costs, dp);
    }
}
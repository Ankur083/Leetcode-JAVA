class Solution {
    public int find(int i, int target, int []costs, int []dp){

        if(i == target){
            return 0;
        }

        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }

        int step1 = Integer.MAX_VALUE;
        int step2 = Integer.MAX_VALUE;
        int step3 = Integer.MAX_VALUE;

        int j = i+1;
        if(j <= target){
             step1 = costs[j-1]+1+find(j, target, costs, dp);
        }
    
        j = i+2;
        if(j <= target){
             step2 = costs[j-1]+4+find(j, target, costs, dp);
        }

        j = i+3;
        if(j <= target){
             step3 = costs[j-1]+9+find(j, target, costs, dp);
        }

        return dp[i] =  Math.min(step1, Math.min(step2, step3));
    }
    public int climbStairs(int n, int[] costs) {

        int []dp = new int[costs.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        
        return find(0, n, costs, dp);
    }
}
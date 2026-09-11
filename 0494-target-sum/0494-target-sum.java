class Solution {
    public int findDifferent(int i, int sum, int [] nums, int target, int [][]dp){

        if(i >= nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        if(dp[i][sum+1000]!= Integer.MAX_VALUE){
            return dp[i][sum+1000];
        }

        int plus = findDifferent(i+1, sum+nums[i], nums, target, dp);
        int minus = findDifferent(i+1, sum-nums[i], nums, target, dp);

        return dp[i][sum+1000] = plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int [][]dp = new int[nums.length][2000+2];

        for(int []r:dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        return findDifferent(0, 0, nums, target, dp);
    }
}
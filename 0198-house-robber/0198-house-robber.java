class Solution {
    public int robMaxAmount(int i, int []nums, int []dp){

        if(i >= nums.length){
            return 0;
        }

        if(i == nums.length-1){
            return nums[i];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i]+robMaxAmount(i+2, nums, dp);
        int noTake = robMaxAmount(i+1, nums, dp);

        return dp[i] = Math.max(take, noTake);
    }
    public int rob(int[] nums) {
        int []dp = new int[nums.length];

        Arrays.fill(dp, -1);
        return robMaxAmount(0, nums, dp);
    }
}
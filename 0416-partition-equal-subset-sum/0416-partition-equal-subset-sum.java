class Solution {
    public boolean findTheSub(int i, int sum, int k, int []nums, Boolean [][]dp ){

        if(sum == k){
            return true;
        }

        if(i >= nums.length || sum > k){
            return false;
        }

        if(dp[i][sum] != null){
            return dp[i][sum];
        }

        boolean take = findTheSub(i+1, sum+nums[i], k, nums, dp);
        boolean noTake = findTheSub(i+1, sum, k, nums, dp);

        return dp[i][sum] = take || noTake;
    }
    public boolean canPartition(int[] nums) {
        int tSum = 0;

        for(int num :nums){
            tSum += num;
        }

        if(tSum % 2 != 0) return false;
        int k = tSum/2;
         Boolean [][]dp = new Boolean[nums.length][k+1];
         
         
        return findTheSub(0, 0, k, nums, dp);
    }
}
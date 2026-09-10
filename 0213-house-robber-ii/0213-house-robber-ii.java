class Solution {
    public int findMax(int i , int n, int []nums, int []dp){
        if(i == n-1){
            return nums[n-1];
        }
        if(i >= n) return 0;

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i]+findMax(i+2, n, nums, dp);
        int notake = findMax(i+1, n, nums, dp);

        return dp[i] = Math.max(take, notake);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        int []dp = new int[nums.length];
        int []dp2 = new int[nums.length];

        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);


        return Math.max(findMax(0, nums.length-1, nums, dp), findMax(1, nums.length, nums, dp2));
    }
}
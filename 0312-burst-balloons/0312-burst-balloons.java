class Solution {
    public int find(int i, int j, int []arr, int [][]dp){
        if(i > j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];

        }

        int ans = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int cost = arr[i-1]*arr[ind]*arr[j+1] + find(i, ind-1, arr, dp) + find(ind+1, j, arr, dp);

            ans = Math.max(ans, cost);
        }
        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int []arr = new int[nums.length+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;

        int [][]dp = new int[nums.length+2][nums.length+2];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }
        for(int i = 1; i <= arr.length-2;i++){
            arr[i] = nums[i-1];
        }

        return find(1, nums.length, arr, dp);
    }
}
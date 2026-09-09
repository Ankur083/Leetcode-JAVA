class Solution {
    public int find(int i, int []arr, int k, int []dp){
        int n = arr.length;

        if(i == n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int maxSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        int len = 0;

        for(int ind = i; ind < Math.min(n, i+k); ind++){
            len++;

            max = Math.max(max, arr[ind]);

            sum = len*max+find(ind+1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int []dp = new int[n];

        Arrays.fill(dp, -1);

        return find(0, arr, k, dp);
    }
}
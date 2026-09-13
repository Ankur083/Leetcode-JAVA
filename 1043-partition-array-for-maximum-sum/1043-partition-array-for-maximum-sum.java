class Solution {
    public int find(int i , int []arr, int k, int []dp){

        if(i == arr.length){
            return 0;
        }


        if(dp[i] != -1){
            return dp[i];
        }

        int max = 0;
        int maxSum = 0;
        int len = 0;
        for(int j = i; j < Math.min(arr.length, i+k); j++){

            len++;
            max = Math.max(max, arr[j]);

            int cost = len*max+find(j+1, arr, k, dp);
            maxSum = Math.max(maxSum, cost);

        }
        return dp[i] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int []dp = new int[arr.length];

        Arrays.fill(dp, -1);

        return find(0, arr, k, dp);
    }
}
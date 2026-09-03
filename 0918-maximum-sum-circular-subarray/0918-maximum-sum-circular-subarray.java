class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ans = 0;
        int n = nums.length;

        // kadanes maxSum
        
        int Max = nums[0];
        int sum1 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += nums[i];
            Max = Math.max(Max, sum1);

            if (sum1 < 0) {
                sum1 = 0;
            }
        }

        if (Max < 0) {
            return Max;
        }

        // kadanes for minSum

        int minSum = Integer.MAX_VALUE;
        int tSum = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            tSum += nums[i];
            sum += nums[i];

            minSum = Math.min(sum, minSum);
            if(sum > 0){
                sum = 0;
            }
        }

        return Math.max(Max, tSum - minSum);
    }
}
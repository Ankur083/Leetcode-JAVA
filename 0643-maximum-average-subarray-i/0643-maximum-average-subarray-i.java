class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int l = 0;
        double maxAvg = Integer.MIN_VALUE;
        double sum = 0.0;

        for(int r = 0; r < nums.length; r++){
            sum += nums[r];

            if(r-l+1 == k){
                maxAvg = Math.max(maxAvg, sum/k);
                sum -= nums[l];
                l++;
            } 
        }
        return maxAvg;
    }
}
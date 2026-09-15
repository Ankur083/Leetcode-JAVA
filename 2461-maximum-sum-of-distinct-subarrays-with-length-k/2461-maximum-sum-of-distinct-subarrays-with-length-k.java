class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int r = 0;

        Map<Integer, Integer>mpp = new HashMap<>();
        long maxSum = 0;
        long sum = 0;
        while(r < nums.length){
            
            while(mpp.containsKey(nums[r])){
                sum -= nums[l];
                mpp.remove(nums[l]);
                l++;
            }
            mpp.put(nums[r], 1);

            sum += nums[r];

            if(mpp.size() == k){
                maxSum = Math.max(maxSum, sum);
                sum -= nums[l];
                mpp.remove(nums[l]);
                l++;
            }

            r++;
        }
        return maxSum;
    }
}
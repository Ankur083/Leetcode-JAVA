class Solution {
    public int maximumSum(int[] nums) {
        
        int ans = Integer.MIN_VALUE;
        int sum = 0;


        for(int num:nums){
            sum += num;

            ans = Math.max(ans, sum);
            if(sum < 0){
                sum = 0;
            }
        }

        int []pre = new int[nums.length];
        int []suff = new int[nums.length];

        pre[0] = nums[0];
        suff[nums.length-1] = nums[nums.length-1];

        for(int i = 1; i < nums.length; i++){
            pre[i] = Math.max(nums[i], nums[i]+pre[i-1]);
        }

        for(int i = nums.length-2; i >= 0; i--){
            suff[i] = Math.max(nums[i], nums[i]+suff[i+1]);
        }

        for(int i = 1; i < nums.length-1; i++){
            ans = Math.max(ans, pre[i-1]+suff[i+1]);
        }
        return ans;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int l = 0;
        int r = 0;
        int tSum = 0;

        for(int num:nums){
            tSum += num;
        }

        int rSum = tSum-x;
        int sum = 0;
        int lonSub = -1;

        if (rSum < 0) return -1;
        if (rSum == 0) return nums.length;

        while(r < nums.length){
            sum += nums[r];


            while( sum > rSum){
                sum -= nums[l];
                l++;
            }

            if(sum == rSum){
                lonSub = Math.max(lonSub, r-l+1);
            }
            r++;
        }

        if(lonSub == -1){
            return -1;
        }
        return nums.length-lonSub;

    }
}
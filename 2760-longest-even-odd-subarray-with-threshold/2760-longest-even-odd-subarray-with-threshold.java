class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int ans = 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(len == 0 && nums[i] % 2 == 0 && nums[i] <= threshold){
                len++;
            }
            else if(i > 0 && len > 0 && nums[i-1] % 2 != nums[i] % 2 && nums[i] <= threshold){
                len++;
            }
            else{
                if(nums[i] % 2 == 0 && nums[i] <= threshold){
                    len = 1;
                }else{
                    len = 0;
                }
            }
            ans = Math.max(len, ans);
        }
        return ans;

    }
}
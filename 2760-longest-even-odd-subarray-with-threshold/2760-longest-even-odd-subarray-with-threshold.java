class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                ans = Math.max(ans, 1); 
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j-1] % 2 == nums[j]%2 || nums[j] > threshold){
                        break;
                    }

                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;

    }
}
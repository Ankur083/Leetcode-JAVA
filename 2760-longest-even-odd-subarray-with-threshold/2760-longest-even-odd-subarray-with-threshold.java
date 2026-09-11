class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        
        int ans = 0;
        int even = 0;
        for(int num:nums){

            if(num % 2 == 0 && num <= threshold){
                even++;
            }
            
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0 && nums[i] <= threshold){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j-1] % 2 == nums[j]%2 || nums[j] > threshold){
                        break;
                    }

                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        if(ans == 0 && even > 0){
            return 1;
        }
        return ans;

    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        boolean flag = false;

        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                flag = true;
            }

            if(nums[i] == 0 || nums[i] < 0 || nums[i] > n){
                nums[i] = 1; 
            }
        }

        if(!flag) return 1;

        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
            
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }

        return n+1;
    }
}
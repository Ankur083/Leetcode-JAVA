class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int minOperation = 0;
        int num = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] > num){
                num = nums[i];
                continue;
            }
            else{
                num = num+1;
                minOperation += (num-nums[i]);
            }
        }
        return minOperation;
    }
}
class Solution {
    public int findDifferent(int i, int sum, int [] nums, int target){

        if(i >= nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int plus = findDifferent(i+1, sum+nums[i], nums, target);
        int minus = findDifferent(i+1, sum-nums[i], nums, target);

        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return findDifferent(0, 0, nums, target);
    }
}
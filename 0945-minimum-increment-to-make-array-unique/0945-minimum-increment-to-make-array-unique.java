class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int next = nums[0];
        int minMoves = 0;

        for(int i = 1;i < nums.length; i++){
            if(next >= nums[i]){
                minMoves += next+1-nums[i];
                next++;
            }
            else{
                next = nums[i];
            }
        }
        return minMoves;
    }
}
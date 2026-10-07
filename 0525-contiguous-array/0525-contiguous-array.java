class Solution {
    public int findMaxLength(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        int []preSum = new int[nums.length];
        Map<Integer, Integer>mpp = new HashMap<>();

        preSum[0] = nums[0];
        
        mpp.put(preSum[0], 0);
        mpp.put(0, -1);
        int ans = 0;

        for(int i = 1; i < nums.length; i++){
            preSum[i] = preSum[i-1]+nums[i];

            if(mpp.containsKey(preSum[i])){
                int ind = mpp.get(preSum[i]);
                ans = Math.max(ans, i-ind);
            }
            else{
                mpp.put(preSum[i], i);
            }
        }
        return ans;
    }
}
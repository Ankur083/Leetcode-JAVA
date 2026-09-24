class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer>mpp = new HashMap<>();

        mpp.put(0, -1);

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum = (sum + nums[i])%k;

            if(mpp.containsKey(sum)){
                if(i-mpp.get(sum) > 1){
                    return true;
                }
            }
            else{
                mpp.put(sum, i);
            }
        }
        return false;
    }
}
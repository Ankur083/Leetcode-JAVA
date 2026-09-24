class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer>mpp = new HashMap<>();

        mpp.put(0, 1);
        int ans = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int rem = sum-k;

            if(mpp.containsKey(rem)){
                ans += mpp.get(rem);
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
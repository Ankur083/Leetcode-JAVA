class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;

        Map<Integer, Integer>mpp = new HashMap<>();

        while(r < nums.length){

            if(mpp.containsKey(nums[r])){
                mpp.put(nums[r], mpp.get(nums[r])+1);
            }
            else{
                mpp.put(nums[r], 1);
            }

            while(mpp.get(nums[r]) > k){
                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }
                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;

            
        }
        return ans;
    }
}
class Solution {
    public int atMost(int []nums, int k){
        if(k < 0) return 0;

        Map<Integer, Integer>mpp = new HashMap<>();
        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < nums.length){
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0)+1);

            while(mpp.size() > k){
                mpp.put(nums[l], mpp.get(nums[l])-1);

                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
}
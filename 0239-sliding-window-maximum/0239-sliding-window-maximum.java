class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer>mpp = new TreeMap<>((a, b) -> b-a);

        int l = 0;
        int r = 0;

        int []ans = new int[nums.length-k+1];
        int i = 0;


        while(r < nums.length){
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0)+1);

            if(r-l+1 == k){
                ans[i] = mpp.firstKey();
                i++;

                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l]) == 0){
                    mpp.remove(nums[l]);
                }
                l++;
            }

            r++;
        }

       return ans; 
    }
}
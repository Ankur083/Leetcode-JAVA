class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer>s = new HashSet<>();

        int l = 0;
        int r = 0;

        int sum = 0;
        int ans = 0;

        while(r < nums.length){
            
            while(s.contains(nums[r])){
                sum -= nums[l];
                s.remove(nums[l]);
                l++;
            }
            sum += nums[r];
            s.add(nums[r]);

            ans = Math.max(ans, sum);
            r++;


        }
        return ans;
    }
}
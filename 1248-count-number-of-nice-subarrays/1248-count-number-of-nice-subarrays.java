class Solution {
     public int atMost(int [] nums, int k){
        int l = 0; 
        int r = 0; 
        int cnt = 0;
        int ans = 0;

        if(k < 0)
            return 0;

        while(r < nums.length){

            if(nums[r] % 2 != 0){
                cnt++;
            }

            while(cnt > k){
                if(nums[l] % 2 != 0){
                    cnt--;
                }
                l++;
            }

            ans += r-l+1;

            r++; 
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
}
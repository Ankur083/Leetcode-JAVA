class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;

        int ans = 0;

        int l = 0;
        int r = 0;

        int cnt = 0;
        while(r < nums.length){
            if(nums[r] == 1){
                cnt++;
                r++;
            }
            else if(k == 1){
                // cnt++;
                k--;
                r++;
            }
            else{
                if(nums[l] == 0){
                    l++;
                    k++;
                }
                else{
                    while(k != 1){
                        if(nums[l] == 0){
                            l++;
                            k++;
                        }
                        else{
                            cnt = cnt-1;
                            l++;
                        }
                    }
                    
                }
            }

            ans = Math.max(ans, cnt);
            
        }
        if(ans == nums.length) return ans-1;
        return ans;
    }
}
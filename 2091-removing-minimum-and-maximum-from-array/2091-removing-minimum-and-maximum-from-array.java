class Solution {
    public int minimumDeletions(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        for(int num :nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int ans = nums.length;

        int cnt = 0;
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min || nums[i] == max){
                cnt++;
                flag++;
                if(flag == 2){
                    break;
                }
            }
            else{
                cnt++;
            }
        }

        ans = Math.min(ans , cnt);
        cnt = 0;
        flag = 0;

        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == min || nums[i] == max){
                cnt++;
                flag++;
                if(flag == 2){
                    break;
                }
            }
            else{
                cnt++;
            }
        }
        ans = Math.min(ans , cnt);
        cnt = 0;
        int cnt1 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min || nums[i] == max){
                cnt++;
                break;
            }
            else{
                cnt++;
            }
        }

        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == min || nums[i] == max){
                cnt1++;
                break;    
            }
            else{
                cnt1++;
            }
        }

        ans = Math.min(ans, cnt+cnt1);
        return ans;
        
    }
}
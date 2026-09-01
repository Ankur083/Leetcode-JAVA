class Solution {
    public int minimumDeletions(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;


        for(int i = 0; i < nums.length ;i++){

            if(max < nums[i]){
                idx1 = i;
                max = nums[i];
            }
            if(min > nums[i]){
                idx2 = i;
                min = nums[i];
            }
           
        }

        int ans = nums.length;

        int cntL = Math.max(idx1, idx2)+1;
        int cntR = nums.length-Math.min(idx1, idx2);
        int cnt = Math.min(idx1, idx2)+1 + (nums.length-Math.max(idx1, idx2));


        return Math.min(cntL, Math.min(cnt, cntR));
        

        // int cnt = 0;
        // int flag = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == min || nums[i] == max){
        //         cnt++;
        //         flag++;
        //         if(flag == 2){
        //             break;
        //         }
        //     }
        //     else{
        //         cnt++;
        //     }
        // }

        // ans = Math.min(ans , cnt);
        // cnt = 0;
        // flag = 0;

        // for(int i = nums.length-1; i >= 0; i--){
        //     if(nums[i] == min || nums[i] == max){
        //         cnt++;
        //         flag++;
        //         if(flag == 2){
        //             break;
        //         }
        //     }
        //     else{
        //         cnt++;
        //     }
        // }
        // ans = Math.min(ans , cnt);
        // cnt = 0;
        // int cnt1 = 0;

        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == min || nums[i] == max){
        //         cnt++;
        //         break;
        //     }
        //     else{
        //         cnt++;
        //     }
        // }

        // for(int i = nums.length-1; i >= 0; i--){
        //     if(nums[i] == min || nums[i] == max){
        //         cnt1++;
        //         break;    
        //     }
        //     else{
        //         cnt1++;
        //     }
        // }

        // ans = Math.min(ans, cnt+cnt1);
        // return ans;
        
    }
}
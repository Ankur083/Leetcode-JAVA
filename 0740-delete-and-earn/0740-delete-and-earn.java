class Solution {
    public int find(int i, int []arr, int []dp){

        if(i >= arr.length){
            return 0;
        }

        if(i == arr.length-1){
            return arr[i];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = arr[i] +find(i+2, arr, dp);
        int notake = find(i+1, arr, dp);

        return dp[i] = Math.max(take, notake);
        
    }
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int []dp = new int[max+1];

        Arrays.fill(dp, -1);

        int []arr = new int[max+1];

        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
        }

        return find(0, arr, dp);
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int n =nums.length;

        if(nums[0]>nums[1])return 0;

        if(nums[n-1]>nums[n-2])return n-1;
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            int mid = l+(r-l)/2;

            if(mid-1 >= 0 && nums[mid-1] < nums[mid] && mid+1 < nums.length && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return -1;
    }
}
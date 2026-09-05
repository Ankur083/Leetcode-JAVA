class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        while(low <= high){
            int mid = low +(high-low)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}
class Solution {

    // dry run on [1, 0, 1, 1, 1] and target = 0
    public boolean search(int[] nums, int target) {
        int low = 0; // 0
        int high = nums.length-1; // 4

        while(low <= high){// 0 <= 4, 1 <= 3, 1 <= 1
            int mid = low +(high-low)/2; // 2, 2, 1

            if(nums[mid] == target){ // 1 == 0 , 1 == 0, 0 == 0
                return true; // return true
            }
            else if(nums[mid] == nums[low] && nums[mid] == nums[high]){// 1 == 1 && 1==1, 0 == 1 && 1==1
                low++;
                high--;
            }
            else if(nums[mid] >= nums[low]){ // 1 >= 0
                if(target >= nums[low] && target < nums[mid]){ // 0 >= 0 && 0 < 1
                    high = mid-1;  // 2-1 = 1
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
class Solution {
    public void reverse(int i, int j, int []nums){

        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }
    public void nextPermutation(int[] nums) {
        boolean flag = false;

        int i = nums.length-2;

        while(i >= 0){
            if(nums[i] >= nums[i+1]){
                i--;
                continue;
            }
            else{
                flag = true;
                break;
            }
        }

      
        if(flag){
            int num = nums[i];
            int maxNum = Integer.MAX_VALUE;
            int ind = -1;
            int j = i+1;
                while(j < nums.length){
                if(num < nums[j] && nums[j] <= maxNum){
                    maxNum = nums[j];
                    ind = j;
                }
                j++;
            }

            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;

            reverse(i+1, nums.length-1, nums);
        }
        else{
            reverse(0, nums.length-1, nums);
        }
    }
}
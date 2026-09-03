class Solution {
    public boolean uniformArray(int[] nums) {
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            } 
        }

        int i = 0;
        // even
        while (i < nums.length) {
            if (nums[i] % 2 == 0) {
                i++;
                continue;
            } else if (nums[i] - minOdd >= 1) {
                i++;
                continue;
            } else {
                break;
            }

        }
        if (i == nums.length) {
            return true;
        }

        i = 0;
        // odd
        while (i < nums.length) {
            if (nums[i] % 2 != 0) {
                i++;
                continue;
            } else if (nums[i] - minOdd >= 1) {
                i++;
                continue;
            } else {
                break;
            }

        }
        if (i == nums.length) {
            return true;
        }

        return false;
    }
}
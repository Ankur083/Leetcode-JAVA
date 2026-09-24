class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int n = nums.length;

        if (k == 0)
            return 0;

        int l = 0;
        int cnt = 0;
        int product = 1;

        for (int r = 0; r < n; r++) {
            product *= nums[r];

            while (product >= k && l<= r) {
                product /= nums[l];
                l++;

            }
            if (product < k)
                cnt += (r - l + 1);

        }
        return cnt;
    }
}
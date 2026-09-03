class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int []ans = new int[m+n];

        int k = 0;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                ans[k++] = nums1[i++];
            }
            else{
                ans[k++] = nums2[j++];
            }
        }

        while(i < m) ans[k++] = nums1[i++];
        while(j < n) ans[k++] = nums2[j++];

        int size = m+n;
        if(size % 2 != 0){
            return (double)ans[(m+n)/2];
        }
        
        double median = (ans[size/2]+ans[(size/2)-1])/2.0;

        return median;
    }
}
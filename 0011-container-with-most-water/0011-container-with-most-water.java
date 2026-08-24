class Solution {
    public int maxArea(int[] height) {

        // brute force approach
        // min(height[j],height[i])*(j-i);

        // int maxArea = 0;

        // for(int i = 0; i < height.length; i++){
        //     for(int j = 0; j < height.length; j++){
        //         maxArea = Math.max(maxArea, Math.min(height[j],height[i])*(j-i));
        //     }
        // }
        // return maxArea;

        int l = 0;
        int r = height.length-1;

        int maxArea = 0;

        while(l < r){
            if(height[l] < height[r]){
                maxArea = Math.max(maxArea, Math.min(height[r],height[l])*(r-l));
                l++;
            }
            else{
                maxArea = Math.max(maxArea, Math.min(height[r],height[l])*(r-l));
                r--;
            }
        }
        return maxArea;
    }
}
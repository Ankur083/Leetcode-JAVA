class Solution {
    public int longestMountain(int[] arr) {

        if(arr.length < 3){
            return 0;
        }

        int longest = 0;
        int []left = new int[arr.length];
        int []right = new int[arr.length];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1]+1;
            }
        }

        for(int i = arr.length-2; i >= 0; i--){
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1]+1;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(left[i] > 0 && right[i] > 0){
                longest = Math.max(longest, left[i]+right[i]+1);
            }
            
        }
        

        return longest;
    }
}
class Solution {
    public int longestMountain(int[] arr) {

        int n =arr.length;

        if(arr.length < 3){
            return 0;
        }

        int longest = 0;
        // int []left = new int[arr.length];
        // int []right = new int[arr.length];

        // for(int i = 1; i < arr.length; i++){
        //     if(arr[i] > arr[i-1]){
        //         left[i] = left[i-1]+1;
        //     }
        // }

        // for(int i = arr.length-2; i >= 0; i--){
        //     if(arr[i] > arr[i+1]){
        //         right[i] = right[i+1]+1;
        //     }
        // }

        // for(int i = 0; i < arr.length; i++){
        //     if(left[i] > 0 && right[i] > 0){
        //         longest = Math.max(longest, left[i]+right[i]+1);
        //     }
            
        // }

        int i = 1;

        while(i < arr.length){

            if(arr[i] <= arr[i-1]){
                i++;
                continue;
            }

            int up = 0;
            while(i < n && arr[i] > arr[i-1]){
                up++;
                i++;
            }

            if(i == n || arr[i] >= arr[i-1]){
                continue;
            }

            int down = 0;

            while(i < n && arr[i] < arr[i-1]){
                down++;
                i++;
            }

            longest = Math.max(longest, up+down+1);
        }

        

        return longest;
    }
}
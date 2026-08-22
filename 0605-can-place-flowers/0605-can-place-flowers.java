class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        
        if(n == 0)return true;
        if(n == 1 && arr.length == 1 && arr[0] == 0) return true;

        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                if(arr[i] == 1){
                    continue;
                }
                else{
                    if(i != arr.length-1 && arr[i+1] != 1){
                        arr[i] = 1;
                        n--;
                    }
                          
                }
            }
            else if(i != arr.length-1){
                if(arr[i] == 1){
                    continue;
                }
                else if(arr[i-1] != 1 && arr[i+1] != 1){
                    arr[i] = 1;
                    n--;
                }
            }
            else{
                if(arr[i] == 0 && i-1 >= 0 && arr[i-1] == 0){
                    arr[i] = 1;
                    n--;
                }
                
            }

            if(n == 0) return true;
        }
        return false;
    }
}
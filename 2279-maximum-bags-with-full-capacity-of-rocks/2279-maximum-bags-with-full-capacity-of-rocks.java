class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int cntOfFullCapcityBags = 0;


        int []arr = new int[capacity.length];

        for(int i = 0; i < capacity.length; i++){
           
            arr[i] = capacity[i]-rocks[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                cntOfFullCapcityBags++;
            }
            else{
                if(arr[i] > additionalRocks){
                    return cntOfFullCapcityBags;
                }
                additionalRocks -= arr[i]; 
                cntOfFullCapcityBags++;
            }
        }
        return cntOfFullCapcityBags;
    }
}
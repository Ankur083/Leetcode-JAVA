class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer>mpp = new HashMap<>();


        for(int i = 0; i <= nums.length-k; i++){
            int l = i;
            int r = l+k;
            HashSet<Integer>s = new HashSet<>();

            while(l < r ){
                if(!s.contains(nums[l])){
                    mpp.put(nums[l], mpp.getOrDefault(nums[l], 0)+1);
                    s.add(nums[l]);
                }
                l++;
                
            }
        }

        int max = -1;

        for(int key:mpp.keySet()){
            if(mpp.get(key) == 1){
                max = Math.max(max, key);
            }
        }

        return max;

    }
}
class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer>mpp = new HashMap<>();

        Map<Integer, List<Integer>>mpp1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
            if(!mpp1.containsKey(nums[i])){
                mpp1.put(nums[i], new ArrayList<>());
            }

            mpp1.get(nums[i]).add(i);
        }

        int cnt = 0;

        for(int key : mpp.keySet()){
            if(mpp.get(key) == 3){
                List<Integer>ls = mpp1.get(key);

                if(ls.get(1)-ls.get(0) == ls.get(2)-ls.get(1)){
                    cnt++;
                }    
            }
        }

        return cnt;
    }
}
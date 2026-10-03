class Solution {
    public int[] findIndices(int[] nums, int idxDiff, int valDiff) {
        int n = nums.length;

        TreeMap<Integer,Integer>mpp = new TreeMap<>();

        int i = 0;
        int j = idxDiff;

        while(j < n){
            mpp.put(nums[i], i);

            int val = nums[j];

            if(mpp.firstKey() != null){
                if(mpp.firstKey() <= val - valDiff){
                    return new int[]{mpp.get(mpp.firstKey()), j};
                }
            }

            if(mpp.lastKey() != null){
                if(mpp.lastKey() >= val + valDiff){
                    return new int[]{mpp.get(mpp.lastKey()), j};
                }
            }

            i++;
            j++;

        }
        return new int[]{-1, -1};
    }
}
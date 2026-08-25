class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer>s = new HashSet<>();

        for(int num:nums){
            s.add(num);
        }

        int i = 1;

        while(i <= nums.length+1){
            int pro = k * i;
            if(!s.contains(pro)){
                return pro;
            }
            i++;
        }
        return 0;
    }
}
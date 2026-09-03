class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer>s = new HashSet<>();

        for(int num : nums){
            if(num > 0){
                s.add(num);
            }
        }

        int i = 1;

        while(i <= 100000){
            if(!s.contains(i)){
                break;
            }
            i++;
        }

        return i;
    }
}
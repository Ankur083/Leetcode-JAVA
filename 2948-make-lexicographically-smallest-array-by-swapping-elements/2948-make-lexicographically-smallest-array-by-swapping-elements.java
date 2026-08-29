class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int []arr = new int [nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(nums);

        Map<Integer, PriorityQueue<Integer>>mpp = new HashMap<>();
        Map<Integer, Integer>mpp1 = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                mpp.put(nums[i], new PriorityQueue<>());
                mpp.get(nums[i]).add(nums[i]);
                mpp1.put(nums[i], nums[i]);
                continue;
            }

            if(nums[i]-nums[i-1] <= limit){
                int parent = mpp1.get(nums[i-1]);
                mpp.get(parent).add(nums[i]);
                mpp1.put(nums[i], parent);
            }
            else{
                mpp.put(nums[i], new PriorityQueue<>());
                mpp.get(nums[i]).add(nums[i]);
                mpp1.put(nums[i], nums[i]);
                
            }
        }
        int []ans = new int[nums.length];
        for(int i = 0; i < arr.length; i++){
            int key = mpp1.get(arr[i]);
            int val = mpp.get(key).poll();
            ans[i] = val;
        }

        return ans;

    }
}
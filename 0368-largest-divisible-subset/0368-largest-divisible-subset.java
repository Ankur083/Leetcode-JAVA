class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int []dp = new int[nums.length];
        int []parent = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIndex = 0;


        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(1+dp[j] > dp[i]){
                        dp[i] = 1+dp[j];
                        parent[i] = j;
                    }
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer>ans = new ArrayList<>();

        while(lastIndex != -1){
            ans.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        Collections.reverse(ans);
        return ans;     
    }
}
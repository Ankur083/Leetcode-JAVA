class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer>mpp = new HashMap<>();

        int l = 0;
        int ans = 0;

        for(int r = 0; r < s.length(); r++){

            while(mpp.containsKey(s.charAt(r))){
                mpp.remove(s.charAt(l));
                l++;
            }
            
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0)+1);
            ans = Math.max(ans, r-l+1);


        }
        return ans;
    }
}
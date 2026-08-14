class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer>mpp = new HashMap<>();

        int l = 0;
        int ans = 0;

        for(int r = 0; r < s.length(); r++){
            
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 0)+1);

            while(mpp.get(s.charAt(r)) > 1){
                mpp.put(s.charAt(l), mpp.get(s.charAt(l))-1);
                l++;
            }

            ans = Math.max(ans, r-l+1);


        }
        return ans;
    }
}
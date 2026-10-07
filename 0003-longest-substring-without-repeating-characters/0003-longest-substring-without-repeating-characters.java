class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer>mpp = new HashMap<>();

        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < s.length()){

            while(mpp.containsKey(s.charAt(r))){
                mpp.remove(s.charAt(l));
                l++;
            }

            mpp.put(s.charAt(r), 1);
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
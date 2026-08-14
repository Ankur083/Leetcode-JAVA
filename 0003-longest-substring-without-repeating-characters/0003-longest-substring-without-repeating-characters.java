class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        // Map<Character, Integer>mpp = new HashMap<>();
        int []freq = new int[128];

        int l = 0;
        int ans = 1;

        for(int r = 0; r < s.length(); r++){

            while(freq[s.charAt(r)] > 0){
                freq[s.charAt(l)]--;
                l++;
            }
            
            freq[s.charAt(r)]++;
            ans = Math.max(ans, r-l+1);


        }
        return ans;
    }
}
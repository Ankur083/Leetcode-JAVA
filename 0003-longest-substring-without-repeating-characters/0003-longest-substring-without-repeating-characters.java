class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        Map<Character, Integer>freq = new HashMap<>();

        int l = 0;
        int r = 0;
        int ans = 1;

        while(r < s.length()){
            char ch = s.charAt(r);

            while(freq.containsKey(ch)){
                freq.remove(s.charAt(l));
                l++;
            }
            
            if(!freq.containsKey(ch)){
                freq.put(ch, 1);
            }


            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
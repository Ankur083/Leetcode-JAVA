class Solution {
     public String reverse(String s){
        int i = 0;
        int j = s.length()-1;
        char []ch = s.toCharArray();

        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
    public int findLongestSubsequence(int i, int j, String s1, String s2, int [][]dp){

        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            take = 1+findLongestSubsequence(i+1, j+1, s1, s2, dp);
        }
        else{
            int take1 = findLongestSubsequence(i+1, j, s1, s2, dp);
            int take2 = findLongestSubsequence(i, j+1, s1, s2, dp);
            return dp[i][j] = Math.max(take1, take2);
        }
        return dp[i][j] = take;
    }

    public int minInsertions(String s) {
        int n = s.length();

        int [][]dp = new int[n][n];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }

        String revS = reverse(s);

        int ans = findLongestSubsequence(0, 0, s, revS, dp);
        return n-ans;
    }
}
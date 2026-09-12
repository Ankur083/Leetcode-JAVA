class Solution {
    public long find(int i, int j, String text, String pattern, long [][]dp){

        if(j == pattern.length()){
            return 1;
        }

        if(i == text.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text.charAt(i) == pattern.charAt(j)){
            return dp[i][j] = find(i+1, j+1, text, pattern, dp)+find(i+1, j, text, pattern, dp);
        }

        return dp[i][j] = find(i+1, j, text, pattern, dp);
    }
    public long maximumSubsequenceCount(String text, String pattern) {

        StringBuilder sb = new StringBuilder();
        sb.append(pattern.charAt(0));
        sb.append(text);

        StringBuilder sb1 = new StringBuilder();
        sb1.append(text);
        sb1.append(pattern.charAt(1));

        long [][]dp = new long[text.length()+1][pattern.length()];

        for(long []r:dp){
            Arrays.fill(r, -1);
        }

        long [][]dp1 = new long[text.length()+1][pattern.length()];

        for(long []r:dp1){
            Arrays.fill(r, -1);
        }

        long ans = Math.max(find(0, 0, sb.toString(), pattern, dp), find(0, 0, sb1.toString(), pattern, dp1));
        return ans;


    }
}
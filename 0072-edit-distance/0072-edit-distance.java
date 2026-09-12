class Solution {
    public int findMinOperation(int i, int j, String s1, String s2, int [][]dp){

       
        if(i == s1.length()){
            return s2.length()-j;
        }
        if(j == s2.length()){
            return s1.length()-i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        
        int ans = 0;

        if(s1.charAt(i) == s2.charAt(j)){
            ans =  findMinOperation(i+1, j+1, s1, s2, dp);
        }
        else{
            int insert = 1+findMinOperation(i, j+1, s1, s2, dp);
            int delete = 1+findMinOperation(i+1, j, s1, s2, dp);
            int replace = 1+findMinOperation(i+1, j+1, s1, s2, dp);
            ans = Math.min(insert, Math.min(delete, replace));
        }

        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int [][] dp= new int[word1.length()][word2.length()];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }
        return findMinOperation(0, 0, word1, word2, dp);

    }
}
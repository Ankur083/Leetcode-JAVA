class Solution {
    public long findMaxPoints(int i, int [][]questions, long []dp){

        if(i >= questions.length){
            return 0;
        }


        if(dp[i] != -1L){
            return dp[i];
        }

        long points = questions[i][0]+findMaxPoints(i+questions[i][1]+1, questions, dp);
    
        long notake = findMaxPoints(i+1, questions, dp);

        return dp[i] = Math.max(points, notake);
    }
    public long mostPoints(int[][] questions) {
        int m = questions.length;

        long []dp = new long[m];

        Arrays.fill(dp, -1L);
        
        return findMaxPoints(0, questions, dp);
    }
}
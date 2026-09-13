class Solution {
    public int find(int cnt, int total, int n, int [][]dp){

        if(total == n){
            return 0;
        }

        if(total > n){
            return (int)1e8;
        }

        if(dp[total][cnt] != -1){
            return dp[total][cnt];
        }

        int days = Integer.MAX_VALUE;
        days = 1+find(cnt+1, total+cnt, n, dp);

        int skip = Integer.MAX_VALUE;
        if(cnt > 1){
            skip = 1+find(1, total, n, dp);
        }

        return dp[total][cnt] = Math.min(skip, days);
    }
    public int minDays(int n) {
        int [][]dp = new int[n][448];

        for(int []r : dp){
            Arrays.fill(r, -1);
        }
        return find(1, 0, n, dp);
    }
}
class Solution {
    public int findScore(int l, int r, int []pref, int []sV, int [][]dp){

        if(l == r) return 0;

        if(dp[l][r] != -1){
            return dp[l][r];
        }

        int ans = 0;
        int x = 0, y = 0, z = 0;
         for(int i = l; i < r; i++){
            int leftSum = 0;
            int rightSum = 0;

            if(l== 0){
                leftSum = pref[i];
            }
            else{
                leftSum = pref[i] - pref[l-1];
            }

            rightSum = pref[r] - pref[i];
            

            if(leftSum < rightSum){
                x = leftSum+findScore(l, i, pref, sV, dp);
                ans = Math.max(ans, x);
            }
            else if(leftSum > rightSum){
                y = rightSum + findScore(i+1, r, pref, sV, dp);
                ans = Math.max(ans, y);
            }
            else{
                z = Math.max(leftSum +findScore(l, i, pref, sV, dp), rightSum+findScore(i+1, r, pref, sV, dp));
                ans = Math.max(ans, z);
            }
        }
        return dp[l][r] = ans;
    }
    public int stoneGameV(int[] sV) {
        if(sV.length == 1){
            return 0;
        }

        int []pref = new int[sV.length];

        pref[0] = sV[0];

        int [][]dp = new int[sV.length][sV.length];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }

        for(int i = 1; i < sV.length; i++){
            pref[i] = sV[i]+pref[i-1];
        }

        return findScore(0, sV.length-1, pref, sV, dp);
    }
}
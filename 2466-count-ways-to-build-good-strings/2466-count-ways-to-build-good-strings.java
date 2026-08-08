class Solution {
    public int findStringsCount(int length, int low, int high, int addZeroCnt, int addOneCnt, long[]dp){

        int MOD = 1000000007;

        int cntString = 0;

        if(length > high){
            return 0;
        }

        if(dp[length] != -1){
            return (int)dp[length];
        }

        if(low <= length ){
            cntString = 1;
        }

        int takeZero = findStringsCount(length+addZeroCnt, low, high, addZeroCnt, addOneCnt, dp);
        int takeOne = findStringsCount(length+addOneCnt, low, high, addZeroCnt, addOneCnt, dp);

        dp[length] = (cntString+(long)takeZero+takeOne) % MOD;
        return (int)dp[length];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {

        long []dp = new long[high+1];

        Arrays.fill(dp, -1L);

      
        return findStringsCount(0, low, high, zero, one, dp);
    }
}
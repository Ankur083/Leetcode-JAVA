class Solution {
    public int find(int i, int j, int []arr, int [][]dp){

        if(i+1 == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int ind = i+1; ind < j; ind++){
            int cost = arr[j] - arr[i] + find(i, ind, arr, dp) + find(ind, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;

    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int []arr = new int[cuts.length+2];

        arr[arr.length-1] = n;

        for(int i = 1; i <= arr.length-2; i++){
            arr[i] = cuts[i-1];
        }

        int [][]dp  = new int[cuts.length+2][cuts.length+2];

        for(int []r :dp){
            Arrays.fill(r, -1);
        }


        return find(0, arr.length-1, arr, dp);
    }
}
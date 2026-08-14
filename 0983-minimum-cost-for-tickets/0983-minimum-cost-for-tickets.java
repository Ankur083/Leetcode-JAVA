class Solution {
    public int find(int i, int []days, int pass, int []costs, int []dp){

        if(i >= days.length){
            return 0;
        }

       
        if (days[i] <= pass) {
            return find(i + 1, days, pass, costs, dp);
        }

         if(dp[i] != -1){
            return dp[i];
        }

        int take1 = costs[0]+find(i+1, days, days[i], costs, dp);
        int take2 = costs[1]+find(i+1, days, days[i]+6, costs, dp);
        int take3 = costs[2]+find(i+1, days, days[i]+29, costs, dp);
        
        return dp[i] = Math.min(take1, Math.min(take2, take3));
        
    }

    public int mincostTickets(int[] days, int[] costs) {

        int []dp = new int[days.length];
        Arrays.fill(dp, -1);

        return find(0, days, 0, costs, dp);
    }
}
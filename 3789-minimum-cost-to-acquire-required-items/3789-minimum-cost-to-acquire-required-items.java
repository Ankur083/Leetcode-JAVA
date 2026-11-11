class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {


        // if(need1 == need2){
        //     if(cost1+cost2 <= costBoth){
        //         return 1L*(cost1+cost2)*need1;
        //     }
        //     return 1L*costBoth*need2;
        // }



        long min1 = 0;
        long min2 = 0;

        min1 = 1L*cost1*need1+1L*cost2*need2;
        min2 = 1L*Math.max(need1, need2) * costBoth;
        long min3 = 1L*Math.abs(need1-need2)*(need1 > need2?cost1:cost2) + 1L*Math.min(need1, need2)*costBoth;

        return Math.min(min1, Math.min(min2, min3));
    }
}
class Solution {
    public int findMin(int i, int j, List<List<Integer>> triangle, int [][]dp){
        int n = triangle.get(i).size();

        if(i == 0 && j == 0){
            return triangle.get(i).get(j);
        }

        if(i < 0 || j < 0 || j >= n){
            return (int)1e9;
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int up = triangle.get(i).get(j)+findMin(i-1, j, triangle, dp);
        int lDig = triangle.get(i).get(j)+findMin(i-1, j-1, triangle, dp);

        return dp[i][j] = Math.min(up, lDig);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int m = triangle.size();

        int [][]dp = new int[m][triangle.get(m-1).size()+1];

        for(int []r:dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        for(int i = 0; i < triangle.get(m-1).size(); i++){
            ans = Math.min(ans, findMin(m-1, i, triangle, dp));
        }

        return ans;
    }
}
class Solution {
    public int findObstacle(int i, int j, int [][]grid, int [][]dp){
       
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1){
            return 0;
        }

        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int bottom = findObstacle(i+1, j, grid, dp);
        int right = findObstacle(i, j+1, grid, dp);

        return dp[i][j] = bottom+right;

        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][]dp = new int[m][n];

        for(int []r:dp){
            Arrays.fill(r, -1);
        }

        return findObstacle(0, 0, obstacleGrid, dp);
    }
}
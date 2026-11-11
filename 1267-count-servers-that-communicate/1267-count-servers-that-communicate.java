class Solution {
    public boolean inServer(int i, int j, int [][]grid){
        int k = i+1;
        while(k < grid.length){
            if(grid[k][j] == 1){
                return true;
            }
            k++;
        }
        
        k = i-1;
        while(k >= 0){
            if(grid[k][j] == 1){
                return true;
            }
            k--;
        }

        k = j+1;
        while(k < grid[0].length){
            if(grid[i][k] == 1){
                return true;
            }
            k++;
        }

        k = j-1;
        while(k >= 0){
            if(grid[i][k] == 1){
                return true;
            }
            k--;
        }
        return false;
    }
    public int countServers(int[][] grid) {
        int ans = 0;


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && inServer(i, j, grid)){
                    ans++;
                }
            }
        }
        return ans;
    }
}
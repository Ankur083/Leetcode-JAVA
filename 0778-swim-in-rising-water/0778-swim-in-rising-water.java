class Solution {
    public boolean check(int [][]grid, int time){
        int n = grid.length;
        int m= grid[0].length;

        Queue<int[]>q = new ArrayDeque<>();
        int [][]vis = new int [n][m];

        q.add(new int[]{0, 0});
        vis[0][0] = 1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int []curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if(x == n-1 && y == m-1){
                    return true;
                }

                if(x-1 >= 0 && vis[x-1][y] != 1 && grid[x-1][y] <= time){
                    q.add(new int []{x-1, y});
                    vis[x-1][y] = 1;
                }
                if(x+1 < n && vis[x+1][y] != 1 && grid[x+1][y] <= time){
                    q.add(new int []{x+1, y});
                    vis[x+1][y] = 1;
                }
                if(y-1 >= 0 && vis[x][y-1] != 1 && grid[x][y-1] <= time){
                    q.add(new int []{x, y-1});
                    vis[x][y-1] = 1;
                }
                if(y+1 < m && vis[x][y+1] != 1 && grid[x][y+1] <= time){
                    q.add(new int []{x, y+1});
                    vis[x][y+1] = 1;
                }
            }
          
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int low = grid[0][0];
        int high = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                high = Math.max(high, grid[i][j]);
            }
        }

        int ans = high;

        while(low <= high){
            int mid = low+(high-low)/2;

            if(check(grid, mid)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
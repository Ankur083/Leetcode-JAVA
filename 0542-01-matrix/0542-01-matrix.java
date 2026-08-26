class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][]ans = new int[m][n];

        Queue<int []>q = new ArrayDeque<>();
        boolean [][]vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
                
            }
        }

        while(!q.isEmpty()){
            int []curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int near = curr[2];

            ans[x][y] = near;

            if(x-1 >= 0 && !vis[x-1][y]){
                q.add(new int[]{x-1, y, near+1});
                vis[x-1][y] = true;
            }
            if(y-1 >= 0 && !vis[x][y-1]){
                q.add(new int[]{x, y-1, near+1});
                vis[x][y-1] = true;
            }
            if(x+1 < m && !vis[x+1][y]){
                q.add(new int[]{x+1, y, near+1});
                vis[x+1][y] = true;
            }
            if(y+1 < n && !vis[x][y+1]){
                q.add(new int[]{x, y+1, near+1});
                vis[x][y+1] = true;
            }
        }

        return ans;

        
    }
}
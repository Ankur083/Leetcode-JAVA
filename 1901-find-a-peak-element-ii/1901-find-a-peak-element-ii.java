class Solution {
    public int[] findPeakGrid(int[][] mat) {
        

        int m = mat.length;
        int n = mat[0].length;

        int l = 0;
        int r = m;

        while(l <= r){
            int row = l+(r-l)/2;

            int col = 0;

           for(int j = 1; j < n; j++){
                if(mat[row][j] > mat[row][col]){
                    col = j;
                }
           }

            if(row > 0 && mat[row-1][col] > mat[row][col]){
                r = row-1;
            }

            else if(row < m-1 && mat[row+1][col] > mat[row][col]){
                l = row+1;
            }
            
            else{
                return new int[]{row, col};
            }
            
        }
        return new int[]{0, 0};
    }
}
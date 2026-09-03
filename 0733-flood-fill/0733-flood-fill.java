class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];

        if(originalColor == color){
            return image;
        }

        Queue<int[]>q = new ArrayDeque<>();

        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int []curr = q.remove();

            int i = curr[0];
            int j = curr[1];

            if(i-1 >= 0 && image[i-1][j] == originalColor){
                q.add(new int[]{i-1, j});
                image[i-1][j] = color;
            }
            if(i+1 < m && image[i+1][j] == originalColor){
               
                q.add(new int[]{i+1, j});
                image[i+1][j] = color;
            }
            if(j-1 >= 0 && image[i][j-1] == originalColor){
                
                q.add(new int[]{i, j-1});
                image[i][j-1] = color;
            }
            if(j+1 < n && image[i][j+1] == originalColor){
            
                q.add(new int[]{i, j+1});
                image[i][j+1] = color;
            }
        }
        return image;
    }
}
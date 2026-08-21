class Solution {
    public int [] find(int [][]board){
        int len = board.length;
        int []arr = new int[len*len+1];
        int row = len-1;
        int k = 1;
        boolean booleanRight  = true;

        while(row >= 0){
            if(booleanRight){
                int col = 0;
                while(col < len){
                    arr[k] = board[row][col];
                    col++;
                    k++;
                }
                booleanRight = false;
            }
            else{
                int col = len-1;
                while(col >= 0){
                    arr[k] = board[row][col];
                    col--;
                    k++;
                }
                booleanRight = true;
            }
            row--;
            
        }
        return arr;
    }
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        boolean []vis = new boolean[len*len+1];
        Queue<int []>q = new ArrayDeque<>();
        int []arr = find(board);

        q.add(new int[]{1, 0});
        vis[1] = true;

        while(!q.isEmpty()){
            int []curr = q.remove();
            int index = curr[0];
            int step = curr[1];

            if(index == len*len){
                return step;
            }

            for(int j = 1; j <= 6 && index+j <= len*len; j++){
                int newIndex = index+j;
                if(!vis[newIndex]){
                    if(arr[newIndex] != -1){
                        q.add(new int[]{arr[newIndex],step+1});
                        vis[newIndex] = true;
                    }
                    else{
                        q.add(new int[]{newIndex,step+1});
                        vis[newIndex] = true;
                    }
                }
            }
        }
        return -1;
    }
}
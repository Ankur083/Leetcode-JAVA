class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int minTime = 0;

        int m = moveTime.length;
        int n = moveTime[0].length;

        boolean [][]vis = new boolean[m][n];
        PriorityQueue<int []>q = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        q.add(new int []{0, 0, 0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int []curr = q.remove();

            int x = curr[0];
            int y = curr[1];
            int time = curr[2];

            if(x == m-1 && y == n-1){
                return time;
            }

            if(x-1 >= 0 && !vis[x-1][y]){
                if(time >= moveTime[x-1][y]){
                    q.add(new int []{x-1, y, time+1});
                    vis[x-1][y] = true;
                }
                else{
                    int t = moveTime[x-1][y]-time;
                    q.add(new int []{x-1, y, time+t+1});
                    vis[x-1][y] = true;
                }
            }
            if(y-1 >= 0 && !vis[x][y-1]){
                if(time >= moveTime[x][y-1]){
                    q.add(new int []{x, y-1, time+1});
                    vis[x][y-1] = true;
                }
                else{
                    int t = moveTime[x][y-1]-time;
                    q.add(new int []{x, y-1, time+t+1});
                    vis[x][y-1] = true;
                }
            }
            if(x+1 < m && !vis[x+1][y]){
                if(time >= moveTime[x+1][y]){
                    q.add(new int []{x+1, y, time+1});
                    vis[x+1][y] = true;
                }
                else{
                    int t = moveTime[x+1][y]-time;
                    q.add(new int []{x+1, y, time+t+1});
                    vis[x+1][y] = true;
                }
            }
            if(y+1 < n && !vis[x][y+1]){
                if(time >= moveTime[x][y+1]){
                    q.add(new int []{x, y+1, time+1});
                    vis[x][y+1] = true;
                }
                else{
                    int t = moveTime[x][y+1]-time;
                    q.add(new int []{x, y+1, time+t+1});
                    vis[x][y+1] = true;
                }
            }

        }

        return -1;

    
    }
}
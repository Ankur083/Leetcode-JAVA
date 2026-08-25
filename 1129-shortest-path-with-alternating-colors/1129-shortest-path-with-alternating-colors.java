class Solution {
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        List<List<Integer>>redAdj = new ArrayList<>();
        List<List<Integer>>blueAdj = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            redAdj.add(new ArrayList());
            blueAdj.add(new ArrayList());
        }

        for(int i = 0; i < redEdges.length;i++){
            int a = redEdges[i][0];
            int b = redEdges[i][1];

            redAdj.get(a).add(b);
        }

        for(int i = 0; i < blueEdges.length;i++){
            int a = blueEdges[i][0];
            int b = blueEdges[i][1];

            blueAdj.get(a).add(b);
        }

        int [][]vis = new int[n][2];
        int []ans = new int[n];

        Arrays.fill(ans, -1);

        Queue<int []>q = new ArrayDeque<>();
        q.add(new int[]{0, -1});//(node, colour);

        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int []curr = q.remove();
                int node = curr[0];
                int colour = curr[1];

                if(ans[node] == -1){
                    ans[node] = cnt;
                }


                if(colour != 0){
                    for(int nei:redAdj.get(node)){
                        if(vis[nei][0] != 1){
                            q.add(new int[]{nei, 0});
                            vis[nei][0] = 1;
                        }
                    }
                }

                if(colour != 1){
                    for(int nei:blueAdj.get(node)){
                        if(vis[nei][1] != 1){
                            q.add(new int[]{nei, 1});
                            vis[nei][1] = 1;
                        }
                    }
                }
            }
            cnt++;
        }
        return ans;

        



    }
}
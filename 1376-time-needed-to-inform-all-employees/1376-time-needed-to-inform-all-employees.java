class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Integer>>adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            if(manager[i] == -1){
                continue;
            }

            adj.get(manager[i]).add(i);
        }

        int time = 0;
        boolean []vis = new boolean[n];
        Queue<int[]>q = new ArrayDeque<>();

        q.add(new int []{headID, 0});
        vis[headID] = true;

        while(!q.isEmpty()){
            int []curr = q.remove();
            int node = curr[0];
            int t = curr[1];

            time = Math.max(time, t);

            for(int nei:adj.get(node)){
                if(!vis[nei]){
                    q.add(new int[]{nei, t+informTime[node]});
                    vis[nei] = true;
                }
            }

        }
        return time;
    }
}
class Solution {
 
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;

        List<List<long[]>>adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];

            adj.get(u).add(new long[]{v, time});
            adj.get(v).add(new long[]{u, time});
        }

        long []distance = new long[n];
        long []ways = new long[n];

        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<long[]>pq = new PriorityQueue<>((a, b)-> Long.compare(a[1], b[1]));

        pq.add(new long[]{0, 0});
        distance[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            long []curr = pq.poll();

            int node = (int)curr[0];
            long t = curr[1];

            for(long []adjacent:adj.get(node)){
                int adjNode = (int)adjacent[0];
                long time = adjacent[1];

                if(t+time < distance[adjNode]){
                    distance[adjNode] = t+time;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{adjNode, t+time});
                }
                else if(t+time == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ways[node])%MOD;
                }

                
            }
        }
        return (int)ways[n-1];
    }
}
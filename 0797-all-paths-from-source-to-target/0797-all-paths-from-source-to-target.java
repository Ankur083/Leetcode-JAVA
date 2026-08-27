class Solution {
    public void dfs(int node, int target,List<List<Integer>>ans, List<List<Integer>>adj, List<Integer>temp){

        temp.add(node);

        if(node == target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int nei : adj.get(node)){
            dfs(nei, target, ans, adj, temp);
            temp.remove(temp.size()-1);
        }
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans = new ArrayList<>();
        List<List<Integer>>adj = new ArrayList<>();

        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        dfs(0, graph.length-1, ans, adj, new ArrayList<>());

        return ans;


    }
}
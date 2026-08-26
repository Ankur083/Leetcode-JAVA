/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>>graph){
        if(node == null){
            return;
        }
        graph.putIfAbsent(node.val, new ArrayList<>());

        if(parent != null){
            graph.get(node.val).add(parent.val);

            graph.putIfAbsent(parent.val, new ArrayList<>());
            graph.get(parent.val).add(node.val);

        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans = new ArrayList<>();

        Map<Integer, List<Integer>>graph = new HashMap<>();

        buildGraph(root, null, graph);

        Queue<int []>q = new ArrayDeque<>();
        Set<Integer>s = new HashSet<>();

        q.add(new int[]{target.val, 0});
        s.add(target.val);

        while(!q.isEmpty()){
            int []curr = q.remove();
            int node = curr[0];
            int d = curr[1];

            if(d == k){
                ans.add(node);
            }

            for(int val:graph.get(node)){
                if(!s.contains(val)){
                    q.add(new int[]{val, d+1});
                    s.add(val);
                }
            }
        }
        return ans;

    }
}
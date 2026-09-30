class Solution {
    public void find(int i, List<Integer>temp, int []c, int target, List<List<Integer>>ans){
      



        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ind = i; ind < c.length; ind++){
            
            if(ind > i && c[ind] == c[ind-1]){
                continue;
            }

            if(c[ind] > target) break;
            
            temp.add(c[ind]);
            find(ind+1, temp, c, target-c[ind], ans);
            temp.remove(temp.size()-1);
        
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();

        Arrays.sort(candidates);

        find(0, new ArrayList<>(), candidates, target, ans);
        return ans;
    }
}
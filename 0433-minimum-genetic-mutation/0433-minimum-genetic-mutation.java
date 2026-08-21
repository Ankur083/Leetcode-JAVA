class Solution {
    public boolean oneMutation(String a, String b){
        int diff = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        List<String>genes = new ArrayList<>();

        genes.add(startGene);

        for(String str:bank){
            genes.add(str);
        }

        Map<String, List<String>>graph = new HashMap<>();

        for(String gene:genes){
            graph.put(gene, new ArrayList<>());
        }

        for(int i = 0; i < genes.size(); i++){
            for(int j = i+1; j < genes.size(); j++){
                if(oneMutation(genes.get(i),genes.get(j))){
                    graph.get(genes.get(i)).add(genes.get(j));
                    graph.get(genes.get(j)).add(genes.get(i));
                }
            }
        }

        Queue<String>q = new ArrayDeque<>();
        Set<String>vis = new HashSet<>();

        q.add(startGene);
        vis.add(startGene);
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String s = q.remove();

                if(s.equals(endGene)){
                    return ans;
                }

                for(String str :graph.get(s)){
                    if(!vis.contains(str)){
                        q.add(str);
                        vis.add(str);
                    }
                }
            }
            
            ans++;
        }

        return -1;
    }
}
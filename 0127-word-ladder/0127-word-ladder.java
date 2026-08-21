class Solution {
    public boolean oneDiffer(String a, String b){
        int diff = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String>word = new ArrayList<>();
        word.add(beginWord);

        for(String str:wordList){
            word.add(str);
        }

        Map<String, List<String>>graph = new HashMap<>();

        for(String s:word){
            graph.put(s, new ArrayList<>());
        }

        for(int i = 0; i < word.size(); i++){
            for(int j = i+1; j < word.size(); j++){
                if(oneDiffer(word.get(i),word.get(j))){
                    graph.get(word.get(i)).add(word.get(j));
                    graph.get(word.get(j)).add(word.get(i));
                }
            }
        }

        Queue<String>q = new ArrayDeque<>();
        Set<String>vis = new HashSet<>();

        q.add(beginWord);
        vis.add(beginWord);

        int ans = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String s = q.remove();

                if(s.equals(endWord)){
                    return ans;
                }

                for(String str:graph.get(s)){
                    if(!vis.contains(str)){
                        q.add(str);
                        vis.add(str);
                    }
                }
            }
            ans++;
            
        }
        return 0;
    }
}
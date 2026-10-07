class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans = new ArrayList<>();

        Map<String, List<String>>mpp = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char []ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);

            if(!mpp.containsKey(str)){
                mpp.put(str, new ArrayList<>());
            }

            mpp.get(str).add(strs[i]);
        }

        for(List<String>temp:mpp.values()){
            ans.add(temp);
        }
        return ans;
    }
}
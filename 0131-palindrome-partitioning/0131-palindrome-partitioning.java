class Solution {
    public boolean isPalindrome(int i, int j, String s){

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void findPalindromePartition(int ind, String s, List<List<String>>ans, List<String>temp){

        if(ind == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i < s.length(); i++){

            if(isPalindrome(ind, i, s)){
                temp.add(s.substring(ind, i+1));
                findPalindromePartition(i+1, s, ans, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<>();
        findPalindromePartition(0, s, ans, new ArrayList<>());
        return ans;
    }
}
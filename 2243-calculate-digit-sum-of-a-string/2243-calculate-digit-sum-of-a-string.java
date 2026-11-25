class Solution {
    public String digitSum(String s, int k) {

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1= new StringBuilder(); 
        
        while(sb.length() > k){
            int sum = 0;
            int cnt = 0; 
            for(int i = 0; i < sb.length(); i++){
                
                sum += sb.charAt(i)-'0';
                cnt++;

                if(cnt == k){
                    cnt = 0;
                    sb1.append(sum);
                    sum = 0;

                }
            }

            if(sum != 0 || cnt > 0){
                sb1.append(sum);
            }

            sb.setLength(0);
            sb.append(sb1);
            sb1.setLength(0);
        }
        return sb.toString();
    }
}
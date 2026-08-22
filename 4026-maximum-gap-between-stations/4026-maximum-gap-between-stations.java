class Solution {
    public int maximumGap(String skill, String station) {
        int []arrLeft = new int[skill.length()];
        int []arrRight = new int[skill.length()];

        int i = 0;
        int j = 0;

        while(i < skill.length() && j < station.length()){
            if(skill.charAt(i) == station.charAt(j)){
                arrLeft[i] = j;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        if(i < skill.length()) return -1;

        i = skill.length()-1;
        j = station.length()-1;

        while(i >= 0 && j >= 0){
            if(skill.charAt(i) == station.charAt(j)){
                arrRight[i] = j;
                i--;
                j--;
            }
            else{
                j--;
            }
        }

        int maxGap = 0;

        for(int k = 0; k < skill.length()-1; k++){
            maxGap = Math.max(maxGap, arrRight[k+1]-arrLeft[k]);
        }

        return maxGap;
    }
}
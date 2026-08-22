class Solution {
    public int maximumGap(String skill, String station) {
        int []arr1 = new int[skill.length()];
        int []arr2 = new int[skill.length()];

        int i = 0;
        int j = 0;

        while(i < skill.length() && j < station.length()){
            if(skill.charAt(i) == station.charAt(j)){
                arr1[i] = j;
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
                arr2[i] = j;
                i--;
                j--;
            }
            else{
                j--;
            }
        }

        int maxGap = 0;

        for(int k = 0; k < skill.length()-1; k++){
            maxGap = Math.max(maxGap, arr2[k+1]-arr1[k]);
        }

        return maxGap;
    }
}
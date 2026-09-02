class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<int []>merge = new ArrayList<>();

        merge.add(new int[]{intervals[0][0], intervals[0][1]});
        int prevA = intervals[0][0];
        int prevB = intervals[0][1];


        for(int i = 1; i < n; i++){
            int currA = intervals[i][0];
            int currB = intervals[i][1];

            if(prevB < currA){
                merge.add(new int[]{currA, currB});
                prevA = currA;
                prevB = currB;
            }
            else{
                merge.remove(merge.size()-1);
                
                prevB = Math.max(prevB, currB);
                merge.add(new int[]{prevA, prevB});
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }
}
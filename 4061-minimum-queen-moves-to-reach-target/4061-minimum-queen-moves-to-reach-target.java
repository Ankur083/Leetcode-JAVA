class Solution {
    public int minQueenMoves(int[] source, int[] target) {

        int sr = source[0];
        int sc = source[1];

        int tr = target[0];
        int tc = target[1];

        if(sr == tr && sc == tc){
            return 0;
        }

        if((sr+sc == tr+tc)){
            return 1;
        }

        if(Math.abs(tr-sr) == Math.abs(tc-sc)){
            return 1;
        }

        if(sr == tr || sc == tc){
            return 1;
        }

        return 2;
    }
}
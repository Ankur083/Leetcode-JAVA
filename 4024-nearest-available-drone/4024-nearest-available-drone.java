class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        
        int manhattanDistance = Integer.MAX_VALUE;
        int index = -1;

        int tx = target[0];
        int ty = target[1];

        for(int i = 0; i < drones.length; i++){
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int distance = Math.abs(x-tx)+Math.abs(y-ty);

            if(distance <= range){
                if(distance < manhattanDistance){
                    index = i;
                    manhattanDistance = distance;
                }
            }
        }
        return index;
    }
}
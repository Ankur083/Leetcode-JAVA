class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mpp = new HashMap<>();

        for (int[] a : reservedSeats) {
            if (!mpp.containsKey(a[0])) {
                mpp.put(a[0], new HashSet<>());
            }

            mpp.get(a[0]).add(a[1]);
        }

        int cnt = (n - mpp.size()) * 2;

        for (Set<Integer> s : mpp.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int j = 2; j <= 5; j++) {
                if (s.contains(j)) {
                    left = false;
                    break;
                }
            }
            for (int j = 4; j <= 7; j++) {
                if (s.contains(j)) {
                    middle = false;
                    break;
                }
            }
            for (int j = 6; j <= 9; j++) {
                if (s.contains(j)) {
                    right = false;
                    break;
                }
            }

            if (left && right)
                cnt += 2;
            else if (left || middle || right)
                cnt += 1;
        }

        return cnt;
    }
}
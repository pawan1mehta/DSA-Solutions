class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        ArrayList<int[]> list1 = new ArrayList<>();
        ArrayList<int[]> list2 = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(img1[i][j] == 1) {
                    list1.add(new int[]{i, j});
                }
                if(img2[i][j] == 1) {
                    list2.add(new int[]{i, j});
                }
            }
        }

        Map<String, Integer> count = new HashMap<>();

        for(int[] a : list1) {
            for(int[] b : list2) {
                String key = (a[0] - b[0]) + " " + (a[1] - b[1]);
                count.put(key, count.getOrDefault(key, 0) + 1);
            }
        }

        int maxVal = 0;
        for(int val : count.values()) {
            maxVal = Math.max(maxVal, val);
        }

        return maxVal;
    }
}
class Solution {

    private int findRightIdx(String s, int i, int[] left, int[] right) {
        int rightIdx = right[s.charAt(i) - 'a'];

        for(int j = i; j <= rightIdx; j++) {
            if(left[s.charAt(j) - 'a'] < i) {
                return -1;
            }
            rightIdx = Math.max(rightIdx, right[s.charAt(j) - 'a']);
        }

        return rightIdx;
    }

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, s.length());

        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            left[idx] = Math.min(left[idx], i);
            right[idx] = i;
        }

        var res = new ArrayList<String>();
        
        int r = -1;

        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if(left[idx] == i) {
                int rightIdx = findRightIdx(s, i, left, right);
                if(rightIdx != -1) {
                    if(i > r) {
                        res.add("");
                    }
                    r = rightIdx;
                    res.set(res.size() - 1, s.substring(i, rightIdx + 1));
                }
            }
        }

        return res;
    }
}
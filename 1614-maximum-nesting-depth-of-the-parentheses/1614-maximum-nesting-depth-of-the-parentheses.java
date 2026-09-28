class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int openParentheses = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == ')') {
                if(ch == '(') {
                    openParentheses++;
                } else {
                    openParentheses--;
                }
                maxDepth = Math.max(maxDepth, openParentheses);
            }
        }

        return maxDepth;
    }
}
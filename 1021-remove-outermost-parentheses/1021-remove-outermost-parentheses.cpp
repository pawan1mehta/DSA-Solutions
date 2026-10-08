class Solution {
public:
    string removeOuterParentheses(string s) {
        int n = s.size();

        string res = "";
        
        int openIdx = 0;
        int open = 0;

        for(int i = 0;  i < n; i++) {
            char ch = s[i];
            
            if(ch == '(') {
                if(open == 0)
                    openIdx = i;
                open++;
            } else {
                open--;
            }

            if(open == 0) {
                int len = i - (openIdx + 1);
                if(len > 0) {
                    res += s.substr(openIdx + 1, len);
                }
            }
        }
        
        return res;
    }
};
class Solution {
public:
    int scoreOfParentheses(string s) {
        stack<int> st;
        st.push(0);
        
        for(char ch : s) {
            if(ch == '(') {
                st.push(0);
            } else {
                int prevVal = st.top(); st.pop();
                int val = 0;
                if(prevVal > 0) {
                    val = 2 * prevVal;
                } else {
                    val = 1;
                }
                st.top() += val;
            }
        }
        
        return st.top();
    }   
};
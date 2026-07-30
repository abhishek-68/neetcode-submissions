class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                st.push(c);
            }
            else if( !st.isEmpty() && (
                           (st.peek() == '[' && c == ']') 
                        || (st.peek() == '{' && c == '}')
                        || (st.peek() == '(' && c == ')') )
            ) {
                st.pop();
            }
            else {
                return false;
            }
        }

        return st.isEmpty();
    }
}

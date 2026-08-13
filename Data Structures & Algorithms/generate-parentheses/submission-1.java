class Solution {
    List<String> ans = new ArrayList<>();
    private void backtrack(int open, int close, int n, StringBuilder sb) {
        if(2*n == sb.length()) {
            ans.add(sb.toString());
            return;
        }
 
        if(open < n) {
            sb.append("(");
            backtrack(open+1, close, n, sb);
            sb.setLength(sb.length() - 1);
        }

        if(close < open) {
            sb.append(")");
            backtrack(open, close+1, n, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return ans;
    }
}

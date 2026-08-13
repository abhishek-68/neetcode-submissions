class Solution {
    List<String> ans = new ArrayList<>();

    private boolean isValid(String s) {
        int cnt = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                cnt++;
            }
            else if(ch == ')') {
                cnt--;
            }

            // A closing bracket appeared before a matching opening bracket
            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }

    private void backtrack(int n, StringBuilder sb) {
        if(2*n == sb.length()) {
            String s = sb.toString();
            if(isValid(s)) {
                ans.add(s);
            }
            return;
        }

        sb.append("(");
        backtrack(n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        backtrack(n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb);
        return ans;
    }
}

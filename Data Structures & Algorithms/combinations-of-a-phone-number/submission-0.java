class Solution {
    List<String> ans;

    private void solve(String digits, int idx, StringBuilder output, String[] mapping) {
        // base case
        if(idx == digits.length()) {
            ans.add(output.toString());
            return;
        }

        int number = digits.charAt(idx) - '0';
        String val = mapping[number];
        for(int i=0; i<val.length(); i++) {
            output.append(val.charAt(i));
            solve(digits, idx+1, output, mapping);
            output.deleteCharAt(output.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length() == 0) {
            return ans;
        }
        StringBuilder output = new StringBuilder();

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        solve(digits, 0, output, mapping);
        return ans;
    }
}

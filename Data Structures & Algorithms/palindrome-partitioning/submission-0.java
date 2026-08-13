class Solution {
    List<List<String>> ans = new ArrayList<>();

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void dfs(int idx, String s, List<String> path) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                dfs(i+1, s, path);
                path.remove(path.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return ans;
    }
}

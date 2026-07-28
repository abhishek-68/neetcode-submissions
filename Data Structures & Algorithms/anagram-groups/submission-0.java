class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);

            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(var entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}

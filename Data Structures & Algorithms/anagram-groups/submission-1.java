class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }
}
class Solution {
    private static final char SEP = (char)257;

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str).append(SEP);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        if (s.isEmpty()) return new ArrayList<>();

        String[] arr = s.split(String.valueOf(SEP), -1);

        List<String> ans = new ArrayList<>();

        // Ignore the last empty string caused by trailing separator
        for (int i = 0; i < arr.length - 1; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}

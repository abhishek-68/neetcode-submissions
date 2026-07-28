class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            sb.append(str.length())
                .append("#")
                .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans  = new ArrayList<>();
        int i = 0;

        while(i < s.length()) {
            int j = i;

            // Find '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));

            j++; // Move after '#'

            ans.add(s.substring(j, j + len));

            i = j + len;
        }

        return ans;
    }
}

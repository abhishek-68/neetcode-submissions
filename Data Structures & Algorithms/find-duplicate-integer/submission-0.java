class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int n : nums) {
            if(st.contains(n)) {
                return n;
            }
            st.add(n);
        }
        return -1;
    }
}

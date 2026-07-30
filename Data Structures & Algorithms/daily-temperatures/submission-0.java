class Pair {
    int temp;
    int idx;

    Pair(int t, int i) {
        temp = t;
        idx = i;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        
        // Loop from right to left
        for (int i = n - 1; i >= 0; i--) { 
            // Pop elements that are smaller or equal to the current temperature
            while (!st.isEmpty() && st.peek().temp <= temperatures[i]) {
                st.pop();
            }
            
            // If stack is empty, no warmer day exists. Otherwise, calculate distance.
            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek().idx - i;
            }
            
            // Push the current temperature and index onto the stack
            st.push(new Pair(temperatures[i], i));
        } 
        return ans; 
    }
}

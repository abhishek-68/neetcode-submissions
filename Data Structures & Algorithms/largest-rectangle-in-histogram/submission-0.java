class Solution { 
    // Find Next Smaller Element Index
    private int[] findNSE(int[] arr) { 
        int n = arr.length; 
        int[] ans = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = n - 1; i >= 0; i--) { 
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) { 
                st.pop(); 
            } 
            // If no smaller element on right, boundary is n
            ans[i] = st.isEmpty() ? n : st.peek(); 
            st.push(i); 
        } 
        return ans; 
    } 

    // Find Previous Smaller Element Index
    private int[] findPSE(int[] arr) { 
        int n = arr.length; 
        int[] ans = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0; i < n; i++) { 
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) { 
                st.pop(); 
            } 
            // If no smaller element on left, boundary is -1
            ans[i] = st.isEmpty() ? -1 : st.peek(); 
            st.add(i); 
        } 
        return ans; 
    } 

    public int largestRectangleArea(int[] heights) { 
        int n = heights.length; 
        if (n == 0) return 0;
        
        int[] pdf = findPSE(heights);
        int[] nsf = findNSE(heights); 
        
        int max_area = 0; 
        for(int i = 0; i < n; i++) { 
            int width = nsf[i] - pdf[i] - 1; 
            int height = heights[i]; 
            int area = width * height; 
            max_area = Math.max(max_area, area); 
        } 
        return max_area; 
    } 
}

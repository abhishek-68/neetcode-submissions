class MinStack {

    Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.add(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> temp = new Stack<>();

        while(!st.isEmpty()) {
            temp.add(st.peek());
            int top = st.pop();
            min = Math.min(min, top);
        }

        while(!temp.isEmpty()) {
            st.add(temp.pop());
        }

        return min;
    }
}

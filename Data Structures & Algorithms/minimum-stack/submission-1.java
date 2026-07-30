class Pair {
    int val;
    int minVal;

    Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<Pair>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            st.push(new Pair(val, val));
        }
        else {
            int mini = Math.min(st.peek().minVal, val);
            st.push(new Pair(val, mini));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().minVal;
    }
}

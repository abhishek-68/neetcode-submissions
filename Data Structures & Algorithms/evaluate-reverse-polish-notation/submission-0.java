class Solution { 
    public int evalRPN(String[] tokens) { 
        Stack<Integer> st = new Stack<>(); 
        
        for (String s : tokens) { 
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) { 
                // Pop operands in reverse order
                int b = st.pop(); 
                int a = st.pop(); 
                
                if (s.equals("+")) { 
                    st.add(a + b); 
                } else if (s.equals("-")) { 
                    st.add(a - b); 
                } else if (s.equals("*")) { 
                    st.add(a * b); 
                } else if (s.equals("/")) { 
                    st.add(a / b); 
                } 
            } else { 
                // Safe to parse as integer since it's not an operator
                st.add(Integer.parseInt(s)); 
            } 
        } 
        return st.pop(); 
    } 
}
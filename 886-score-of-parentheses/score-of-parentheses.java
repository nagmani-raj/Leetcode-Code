class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        // Stack<Character> st = new Stack<>();

        // for(int i=0; i<n; i++){
        //     char ch = s.charAt(i);
        //     if(ch == '('){
        //         st.push(ch);
        //     }
        //     if(ch == ')'){
        //         st.pop();
        //     }
        // }
        int count =0;
        int ct =0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(')count++;
            else{
                count--;
                if(s.charAt(i-1)=='('){
                   ct += 1<<count;
                }
            }
            
        }

       return ct;
    }
}
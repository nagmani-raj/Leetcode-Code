class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(!st.isEmpty()){
                    sb.append(ch);
                }
                st.push(ch);
            }else{
                st.pop();
                if(!st.isEmpty()){
                    sb.append(ch);
                }
            }
        }


        return sb.toString();
    }
}
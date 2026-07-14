class Solution {
    public String reverseWords(String s) {
        String[] word = s.trim().split("\\s+");

        StringBuilder st = new StringBuilder();

        for(int i = word.length-1; i>=0; i--){
            st.append(word[i]);
            if(i != 0) st.append(" ");
        }

        return st.toString();
    }
}
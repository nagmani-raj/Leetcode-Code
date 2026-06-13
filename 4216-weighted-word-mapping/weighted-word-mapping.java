class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for(String word : words){
            int sum = 0;

            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                sum += weights[index];
            }

            int mod = sum % 26;

            char mappedChar = (char)('z' - mod);

            result.append(mappedChar);
        }
        return result.toString();
    }
}
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMapper = new HashMap<>();
        for (List<String> pair : knowledge) {
            knowledgeMapper.put(pair.get(0), pair.get(1));
        }
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char letter = s.charAt(i);
            if (letter == '(') {
                StringBuilder key = new StringBuilder();
                letter = s.charAt(++i);
                while (letter != ')') {
                    key.append(letter);
                    letter = s.charAt(++i);
                }
                answer.append(knowledgeMapper.getOrDefault(key.toString(), "?"));
            } else {
                answer.append(letter);
            }
            i++;
        }
        return answer.toString();
    }
}

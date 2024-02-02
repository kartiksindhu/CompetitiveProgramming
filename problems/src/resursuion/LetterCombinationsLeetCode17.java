package resursuion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsLeetCode17 {
    private static final String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> solve(String input) {
        List<String> result = new ArrayList<>();
        generateCombinations(input, 0, result, "");
        return result;
    }
    private void generateCombinations(String input, int index, List<String> result, String currentCombination) {
        if (index >= input.length()) {
            result.add(currentCombination);
            return;
        }
        StringBuilder currentString = new StringBuilder(currentCombination);
        String indexMapping = mapping[input.charAt(index) - '0'];
        for (int i = 0; i < indexMapping.length(); i++) {
            currentString.append(indexMapping.charAt(i));
            generateCombinations(input, index + 1, result, currentString.toString());
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
    public static void main(String[] args) {
        String input = "23";
        LetterCombinationsLeetCode17 letterCombinations = new LetterCombinationsLeetCode17();
        List<String> result = letterCombinations.solve(input);
        System.out.println("------------------------------------------------------");
        for (String i: result) {
            System.out.print(i + " ");
        }
    }
}

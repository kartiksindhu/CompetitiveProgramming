package resursuion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
    private List<String> solve(String input) {
        List<String> result = new ArrayList<>();
        generatePermutations(new StringBuilder(input), 0, result, "");
        return result;
    }
    private void generatePermutations(StringBuilder input, int index, List<String> result, String currentString) {
        if (0 >= input.length()) {
            result.add(currentString);
        }
        StringBuilder currentStringBuilder = new StringBuilder(currentString);
        for (int i = 0; i < input.length(); i++) {
            currentStringBuilder.append(input.charAt(i));
            char toBedeleted = input.charAt(i);
            generatePermutations(input.deleteCharAt(i), index + 1, result, currentStringBuilder.toString());
            input.insert(i, toBedeleted);
            currentStringBuilder.deleteCharAt(currentStringBuilder.length() - 1);
        }
    }
    public static void main(String[] args) {
        String input = "abc";
        StringPermutations stringPermutations = new StringPermutations();
        List<String> result = stringPermutations.solve(input);
        System.out.println("------------------------------------");
        for (String i: result) {
            System.out.print(i + " ");
        }
    }
}

package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class practice {
    public static void main(String[] args) {
        String s = "[1,[2,3],[4,[5,6]]]";
        Deque<Character> deque = new ArrayDeque<>();
        String temp = "";
        int depth = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                depth++;
                deque.push(s.charAt(i));
            } else if (s.charAt(i) == ']') {
                deque.poll();
                if (temp.length() > 0) {
                    result = result + (Integer.parseInt(temp) * depth);
                }
                temp = "";
                depth--;
            } else if (s.charAt(i) == ',') {
                if (temp.length() > 0) {
                    result = result + (Integer.parseInt(temp) * depth);
                }
                temp = "";
            } else {
                temp = temp + s.charAt(i);
            }
        }
        System.out.println(result);
    }
}

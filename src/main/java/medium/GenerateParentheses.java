package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * {@see https://leetcode.com/problems/generate-parentheses/description/}
 *
 * @author SweetSupremum
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(2).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generate(n, 0, 0, "", parenthesis);
        return parenthesis;
    }

    private void generate(int n, int left, int right, String temp, List<String> parenthesis) {
        if (temp.length() == 2 * n) {
            parenthesis.add(temp);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, temp + "(", parenthesis);
        }
        if (right < left) {
            generate(n, left, right + 1, temp + ")", parenthesis);
        }
    }
}

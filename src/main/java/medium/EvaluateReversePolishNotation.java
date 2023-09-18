package medium;

import java.util.Stack;

/**
 * {@see https://leetcode.com/problems/evaluate-reverse-polish-notation/description/}
 *
 * @author SweetSupremum
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperation(token)) {
                stack.push(Integer.toString(calculate(token, stack.pop(), stack.pop())));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperation(String candidateOperation) {
        return candidateOperation.equals("*") || candidateOperation.equals("/")
                || candidateOperation.equals("-") || candidateOperation.equals("+");
    }

    private int calculate(String operation, String pop, String twoPop) {
        if (operation.equals("*")) {
            return Integer.parseInt(twoPop) * Integer.parseInt(pop);
        }
        if (operation.equals("+")) {
            return Integer.parseInt(twoPop) + Integer.parseInt(pop);
        }
        if (operation.equals("/")) {
            return Integer.parseInt(twoPop) / Integer.parseInt(pop);
        }
        if (operation.equals("-")) {
            return Integer.parseInt(twoPop) - Integer.parseInt(pop);
        }
        throw new IllegalArgumentException("No support operation");
    }
}

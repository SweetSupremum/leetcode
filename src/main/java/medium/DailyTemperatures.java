package medium;

import java.util.Stack;

/**
 * {@see https://leetcode.com/problems/daily-temperatures/}
 *
 * @author SweetSupremum
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] temp = new int[temperatures.length];
        Stack<ValueIndex> numStack = new Stack<>();
        numStack.push(new ValueIndex(0, temperatures[0]));
        for (int i = 1; i < temperatures.length; i++) {
            while (!numStack.isEmpty() && temperatures[i] > numStack.peek().value) {
                ValueIndex pop = numStack.pop();
                temp[pop.index] = i - pop.index;
            }
            numStack.push(new ValueIndex(i, temperatures[i]));
        }
        return temp;
    }

    class ValueIndex {
        public ValueIndex(int index, int value) {
            this.index = index;
            this.value = value;
        }

        int index;
        int value;
    }

}

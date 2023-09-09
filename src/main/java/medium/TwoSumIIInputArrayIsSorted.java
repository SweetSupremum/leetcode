package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/}
 *
 * @author SweetSupremum
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            Integer indexItem = integerMap.get(numbers[i]);
            if (indexItem != null) {
                return new int[]{indexItem + 1, i + 1};
            }
            integerMap.put(diff, i);
        }

        return new int[0];
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@see https://leetcode.com/problems/top-k-frequent-elements/}
 *
 * @author SweetSupremum
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(
                new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 10))
        );
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        int countMax = Integer.MIN_VALUE;
        for (int n : nums) {
            Integer count = elementCountMap.get(n);
            if (count != null) {
                elementCountMap.put(n, ++count);
                if (count > countMax) {
                    countMax = count;
                }
            } else {
                elementCountMap.put(n, 1);
            }
        }
        Map<Integer, List<Integer>> countElementsMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> countElementEntry : elementCountMap.entrySet()) {
            Integer element = countElementEntry.getKey();
            Integer count = countElementEntry.getValue();
            List<Integer> elements = countElementsMap.get(count);
            if (elements != null) {
                elements.add(element);
            } else {
                ArrayList<Integer> initializeListElement = new ArrayList<>();
                initializeListElement.add(element);
                countElementsMap.put(count, initializeListElement);
            }
        }
        int[] total = new int[k];
        int pointer = 0;
        int temp = k;
        while (countMax != 0 && temp != 0) {
            List<Integer> elements = countElementsMap.get(countMax);
            if (elements != null && !elements.isEmpty()) {
                for (int i = 0; i < elements.size(); i++) {
                    total[pointer + i] = elements.get(i);
                }
                pointer += elements.size();
            }
            countMax--;
            if (elements != null) {
                temp -= elements.size();

            }
        }

        return total;
    }
}

package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * {@see https://leetcode.com/problems/longest-consecutive-sequence/}
 *
 * @author SweetSupremum
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> tempSet = new HashSet<>();
        for (int num : nums) {
            tempSet.add(num);
        }
        int currentMaxSeq = 1;
        int tempMax = 1;
        for (int num : nums) {
            if (!tempSet.contains(num - 1)) {
                while (tempSet.contains(num + 1)) {
                    tempMax++;
                    num++;
                }
                if (tempMax > currentMaxSeq) {
                    currentMaxSeq = tempMax;
                }
                tempMax = 1;
            }
        }

        return currentMaxSeq;
    }
}

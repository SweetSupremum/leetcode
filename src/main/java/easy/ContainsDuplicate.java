package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * {@see https://leetcode.com/problems/contains-duplicate/}
 *
 * @author SweetSupremum
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            if (!integerSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}

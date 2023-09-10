package easy;

import java.util.Arrays;

/**
 * {@see https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150}
 *
 * @author SweetSupremum
 */
public class RemoveElement {
    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    /*  Input: nums = [3,2,2,3], val = 3
      Output: 2, nums = [2,2,_3,_3]*/
    public int removeElement(int[] nums, int val) {
        int pointerNotEqualsVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointerNotEqualsVal] = nums[i];
                pointerNotEqualsVal++;
            }
        }
        return pointerNotEqualsVal;
    }
}

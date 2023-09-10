package easy;

import java.util.Arrays;

/**
 * {@see https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150}
 *
 * @author SweetSupremum
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        new MergeSortedArray().merge(nums1, 3, new int[]{-1, 1, 1, 1, 2, 3}, 6);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * nums1 = [1,2,2,3,5,6]
     * 4,5,6,0,0,0
     * 1,2,3
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastNonEmptyPointer = m - 1;
        int currentPointer = nums1.length - 1;
        int lastPointer = n - 1;
        while (lastPointer != -1) {
            int temp = nums2[lastPointer];
            if (lastNonEmptyPointer == -1 || temp > nums1[lastNonEmptyPointer]) {
                nums1[currentPointer] = temp;
                lastPointer--;
            } else {
                int swap = nums1[lastNonEmptyPointer];
                nums1[lastNonEmptyPointer] = nums1[currentPointer];
                nums1[currentPointer] = swap;
                lastNonEmptyPointer--;
            }
            currentPointer--;
        }
    }
}

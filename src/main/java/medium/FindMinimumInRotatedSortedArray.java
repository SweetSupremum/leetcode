package medium;

/**
 * {@see https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/}
 *
 * @author SweetSupremum
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[0]) {
                right = middle;
            }
            if (nums[middle] > nums[0]) {
                left = middle;
            }
        }
        return nums[right];
    }
}

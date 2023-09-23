package easy;

/**
 * {@see https://leetcode.com/problems/binary-search/description/}
 *
 * @author SweetSupremum
 */
public class BinarySearch {


    /**
     * 1 , 2 , 3, 4, 5, 6 , 7
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle;
            }
            if (nums[middle] > target) {
                right = middle;
            }
            left++;
            right--;
        }
        return -1;
    }
}

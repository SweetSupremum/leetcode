package medium;

/**
 * @author SweetSupremum
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{1, 3}, 1));
    }

    /**
     * 4,5,6,7,0,1,2;
     * target = 5;
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] < nums[nums.length - 1]) {
            return bs(left - 1, nums.length, target, nums);
        }
        while (left + 1 < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[0]) {
                right = middle;
            }
            if (nums[middle] > nums[0]) {
                left = middle;
            }
        }
        int minIndex = right;
        if (target == nums[minIndex]) {
            return minIndex;
        }
        int rbs = bs(minIndex, nums.length, target, nums);
        int lbs = bs(-1, minIndex, target, nums);
        if (rbs != -1) {
            return rbs;
        }
        return lbs;
    }

    int bs(int l, int r, int target, int[] nums) {
        while (l + 1 < r) {
            int middle = (l + r) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                l = middle;
            }
            if (nums[middle] > target) {
                r = middle;
            }
        }
        return -1;
    }
}

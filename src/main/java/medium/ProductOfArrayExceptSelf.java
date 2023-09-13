package medium;

/**
 * {@see https://leetcode.com/problems/product-of-array-except-self/description/}
 *
 * @author SweetSupremum
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] total = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total[i] = prefix[i] * suffix[i];
        }
        System.gc();
        return total;
    }
}

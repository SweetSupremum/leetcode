package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SweetSupremum
 * {@see https://leetcode.com/problems/3sum/}
 */
public class ThreeSum {
    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-2, 0, 0, 2, 2}).forEach(list ->
                list.forEach(System.out::println)
        );
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (right == i) {
                    right--;
                }
                int twoSum = -(nums[left] + nums[right]);
                if (twoSum < nums[i]) {
                    right--;
                }
                if (twoSum > nums[i]) {
                    left++;
                }
                if (twoSum == nums[i]) {
                    List<Integer> total = new ArrayList<>();
                    total.add(nums[i]);
                    total.add(nums[left]);
                    total.add(nums[right]);
                    answer.add(total);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return answer;
    }
}

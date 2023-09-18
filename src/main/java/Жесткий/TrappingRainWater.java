package Жесткий;

/**
 * {@see https://leetcode.com/problems/trapping-rain-water/description/}
 *
 * @author SweetSupremum
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{3, 0, 8}));
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        while (left < right) {
            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                right--;
            }
        }
        return area;
    }
  /*      for (int temp : height) {
            if (temp > globalMax) {
                globalMax = temp;
            }
        }
        for (int i = 1; i < height.length; i++) {
            if (height[i] > currentMax) {
                area += (i - indexPrevMax - 1) * currentMax;
                currentMax = height[i];
                indexPrevMax = i;
            } else {
                area -= height[i];
            }
            if (height[i] == globalMax) {
                break;
            }
        }
        currentMax = height[height.length - 1];
        indexPrevMax = height.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > currentMax) {
                area += (indexPrevMax - i - 1) * currentMax;
                currentMax = height[i];
                indexPrevMax = i;
            } else {
                area -= height[i];
            }
            if (height[i] == globalMax) {
                break;
            }
        }*/
    /*return area;*/
}


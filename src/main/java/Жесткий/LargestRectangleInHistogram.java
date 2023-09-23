package Жесткий;

import java.util.Stack;

/**
 * {@see https://leetcode.com/problems/largest-rectangle-in-histogram/description/}
 *
 * @author SweetSupremum
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        /*System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));*/
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 4}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{1, 1}));
        /*System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 3}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0}));
        System.out.println(Arrays.toString(new LargestRectangleInHistogram().previousSmall(new int[]{3, 6, 5, 7, 4, 8, 1, 0})));
        System.out.println(Arrays.toString(new LargestRectangleInHistogram().nextSmall(new int[]{3, 6, 5, 7, 4, 8, 1, 0})));*/

    }

    /**
     * all people call me ebanaya 3 attempt,
     * I'm sad. I'm not ebanaya 3 attempt.
     * I'm hard task on leetcode
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] previousSmall = previousSmall(heights);
        int[] nextSmall = nextSmall(heights);
        int tempArea;
        for (int i = 0; i < heights.length; i++) {
            tempArea = (nextSmall[i] - previousSmall[i] - 1) * heights[i];
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }
        return maxArea;
    }

    /**
     * 3, 6, 5, 7, 4, 8, 1, 0
     */
    private int[] previousSmall(int[] heights) {
        Stack<HeightPosition> integers = new Stack<>();
        int[] smaller = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (!integers.isEmpty() && height <= integers.peek().height) {
                integers.pop();
            }
            if (integers.empty()) {
                smaller[i] = -1;
            } else {
                smaller[i] = integers.peek().position;
            }
            integers.push(new HeightPosition(height, i));
        }
        return smaller;
    }

    private int[] nextSmall(int[] heights) {
        Stack<HeightPosition> integers = new Stack<>();
        int[] smaller = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            while (!integers.isEmpty() && height <= integers.peek().height) {
                integers.pop();
            }
            if (integers.empty()) {
                smaller[i] = heights.length;
            } else {
                smaller[i] = integers.peek().position;
            }
            integers.push(new HeightPosition(height, i));
        }
        return smaller;
    }
/*
    public int largestRectangleArea(int[] heights) {
        *//*int maxArea = heights[0];*//*
     *//*        Stack<HeightPosition> heightPositions = new Stack<>();
        heightPositions.push(new HeightPosition(heights[0], 0));
        int tempArea;
        for (int i = 1; i < heights.length; i++) {
            int reset = 0;
            while (!heightPositions.isEmpty() && heights[i] < heightPositions.peek().height) {
                reset++;
                HeightPosition heightPosition = heightPositions.pop();
                tempArea = heightPosition.height * (i - heightPosition.position);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
            heightPositions.push(new HeightPosition(heights[i], i - reset));
        }

        while (!heightPositions.isEmpty()) {
            HeightPosition pop = heightPositions.pop();
            tempArea = pop.height * (heights.length - pop.position);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }*//*
     *//* return maxArea;*//*
    }*/

    class HeightPosition {
        int height;
        int position;

        public HeightPosition(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }
/*    public int largestRectangleArea(int[] heights) {
        int totalArea = heights[0];
        int tempMin = heights[0];
        Stack<Integer> histogramStack = new Stack<>();
        histogramStack.push(heights[0]);
        int areaTemp = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < tempMin) {
                tempMin = heights[i];
            }
            if (heights[i] >= histogramStack.peek()) {
                while (histogramStack.peek() == heights[i]) {
                    areaTemp += histogramStack.pop();
                }
                if (areaTemp > totalArea) {
                    totalArea = areaTemp;
                } else {
                    totalArea += tempMin;
                }
                histogramStack.push(heights[i]);
            } else {
                int tempArea;
                if (heights[i] > tempMin) {
                    tempArea = (i + 1) * tempMin;
                } else {
                    tempArea = (i + 1) * heights[i];
                }
                if (tempArea > totalArea) {
                    totalArea = tempArea;
                }
            }
        }
        return totalArea;
    }*/
}

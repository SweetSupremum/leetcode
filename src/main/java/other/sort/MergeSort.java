package other.sort;

import java.util.Arrays;

/**
 * @author SweetSupremum
 */
public class MergeSort implements Sortable {
    public static void main(String[] args) {
        new MergeSort().sort(new int[]{5, 6, 4, 3, 0, 12, 11});
    }

    @Override
    public void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        int length = arr.length;
        int middle = length / 2;
        int rightLen = length - middle;
        int[] right = new int[rightLen];
        int[] left = new int[middle];
        for (int i = 0; i < length; i++) {
            if (i < middle) {
                left[i] = arr[i];
            } else {
                right[i - middle] = arr[i];
            }
        }
        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    /**
     * 2,9    4,5
     */
    private void merge(int[] arr, int[] left, int[] right) {
        int rightLength = right.length;
        int leftLength = left.length;
        int[] temp = new int[leftLength + rightLength];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (rightIndex == rightLength) {
                temp[i] = left[leftIndex];
                leftIndex++;
                continue;
            }
            if (leftIndex == leftLength) {
                temp[i] = right[rightIndex];
                rightIndex++;
                continue;
            }
            if (left[leftIndex] < right[rightIndex]) {
                temp[i] = left[leftIndex];
                leftIndex++;
            } else {
                temp[i] = right[rightIndex];
                rightIndex++;
            }
        }
        System.out.println("left");
        System.out.println(Arrays.toString(left));
        System.out.println("right");
        System.out.println(Arrays.toString(right));
        System.out.println("temp");
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < temp.length; i++) {
            System.out.println("mini temp");
            System.out.println(arr[i]);
            arr[i] = temp[i];
        }
    }

}

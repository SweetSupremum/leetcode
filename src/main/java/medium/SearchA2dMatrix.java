package medium;

/**
 * {@see https://leetcode.com/problems/search-a-2d-matrix/description/}
 *
 * @author SweetSupremum
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        int right = m * n - 1;
        int left = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            int row = middle / m;
            int col = middle % m;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = middle + 1;
            }
            if (matrix[row][col] > target) {
                right = middle - 1;
            }
        }
        return false;
    }
}

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //int length = dfs(i, j, matrix, cache, Integer.MAX_VALUE);
                int length = dfs(i, j, matrix, cache, Integer.MIN_VALUE);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] cache, int pre) {
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(dfs(i - 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i + 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i, j - 1, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i, j + 1, matrix, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
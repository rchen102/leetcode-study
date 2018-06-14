//Solution1: dynamic programming T: O(mn) S: O(max(rows,cols))
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] left = new int[cols];
        int[] right = new int[cols];
        int[] height = new int[cols];
        
        Arrays.fill(right, cols);
        int res = 0;
        
        for(int i = 0; i < rows; i++) {
            int curLeft = 0, curRight = cols;
            for(int j = 0; j < cols; j++) {  //compute height
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for(int j = 0; j < cols; j++) {  //compute left
                if(matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for(int j = cols - 1; j >= 0; j--) {  //compute right
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = cols;
                    curRight = j;
                }
            }
            for(int j = 0; j < cols; j++) {  //compute area
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }
}
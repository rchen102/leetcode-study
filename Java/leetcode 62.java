//Solution1: DP T: O(mn) S: O(mn)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m-1][n-1];
    }
}

//Solution update: T: O(mn) S: O(Math.min(m, n))
class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) res[j] = 1;
                else res[j] = res[j-1] + res[j];
            }
        }
        return res[n-1];
    }
}
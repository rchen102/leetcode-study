/* Solution: Two Pointers
 * T: O(n) S: O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        while (cur < nums.length) {
            nums[cur] = 0;
            cur++;
        }
    }
}
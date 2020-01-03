/* Solution1: two pointers 
 * T: O(n) S: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[cur-1]) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}
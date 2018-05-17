class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
            else return mid;
        }
        return left;
    }
}
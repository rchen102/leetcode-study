//Solution1 :
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2])
                right = mid1;
            else
                left = mid2;
        }
        return left;
    }
}

//Solution2:





class Solution {
    public int findPeakElement(int[] nums) {
        int tmp = 0;
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i] > nums[i-1])
                tmp = i;
            else if(nums[i-1] == nums[tmp])
                return tmp;
        }
        return tmp;
    }
}
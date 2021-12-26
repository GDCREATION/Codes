public class FirstLastPositionSortedArray {
    /**Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity. */
        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            if(high == -1)
                return new int[]{-1,-1};
            int mid = low +(high-low)/2;
            while(low<high && nums[mid] != target){
                if(nums[mid]>target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
                mid = low +(high-low)/2;
            }
            if(nums[mid]==target){
                int left = mid-1;
                int right = mid+1;
                while((left>=0 && nums[left]==target)
    || (right < nums.length && nums[right] == target)){
                    if(left>=0 && nums[left]==target)
                        left--;
                    if(right < nums.length && nums[right]==target)
                        right++;
                }
                return new int[]{++left,--right};
            }
            return new int[]{-1,-1};
        }
    }

public class MaxLengthSubArrayPositiveProdut {
    /**Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product. */
        public int getMaxLen(int[] nums) {
            int max =0,min=0,currMax=0,mi=1,mini=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    currMax++;
                    min++;
                }else if(nums[i]<0){
                    if(mini == -1)
                        mini = i;
                    mi = mi*-1;
                    min++;
                    if(mi >0&& min > currMax)
                        currMax = min;
                    else{
                        max = Math.max(max,currMax);
                        currMax = i-mini;
                    }
                        
                }else{
                    max = Math.max(max,currMax);
                    currMax = 0;
                    mi=1;
                    min=0;
                    mini =-1;
                }
                
            }
            max = Math.max(max,currMax);
            return max;
        }
    }

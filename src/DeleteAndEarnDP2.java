import java.util.Arrays;

/*You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.*/

public class DeleteAndEarnDP2 {
        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
            int res[]=new int[nums.length+1];
            res[0]=0;
            res[1]=nums[0];
            int temp =0;
            int max=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[i-1]+1){
                    res[i+1] = (temp-1)<0? nums[i]:nums[i]+Math.max(max,res[temp]);
                    temp=i;
                    max= Math.max(max,res[temp]);
                }
                else if(nums[i]!=nums[i-1]){
                    res[i+1] = Math.max(res[i],res[temp])+nums[i];
                    max = Math.max(max,res[i]);
                    temp=i;
                }
                else{
                    res[i+1] = res[i]+nums[i];
                }
                
            }
            return Math.max(res[nums.length],res[temp]);
        }
    }
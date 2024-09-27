class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
        int start = 0,end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start;
        */
        int p=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
            return i;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<target && nums[i+1]>target)
            return i+1;
        }
        if(target<nums[0])
        return 0;
        return nums.length;
    }
}
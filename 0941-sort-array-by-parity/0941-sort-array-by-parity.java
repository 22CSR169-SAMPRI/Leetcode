class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0,j;
        
        for(i=0;i<nums.length-1;i++){
            if(nums[i]%2!=0){
                for(j=i+1;j<nums.length-1;j++){
                    if(nums[j]%2==0)
                    break;
                }
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        return nums;
    }
}
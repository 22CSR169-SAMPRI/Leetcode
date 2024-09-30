class Solution {
    public void sortColors(int[] nums) {
        // int low=0,high=nums.length-1,middle=0,temp;
        // while(middle<=high){
        //     if(nums[middle]==0){
        //         temp=nums[middle];
        //         nums[middle]=nums[low];
        //         nums[low]=temp;
        //         low++;
        //         middle++;

        //     }
        //     else if(nums[middle]==1){
        //         middle++;
        //     }
        //     else if(nums[middle]==2){
        //         temp=nums[middle];
        //         nums[middle]=nums[high];
        //         nums[high]=temp;
        //         high--;
        //     }
        //     //i++;
        // }
        Arrays.sort(nums);
    }
}
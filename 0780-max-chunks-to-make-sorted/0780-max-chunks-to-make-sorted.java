class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunk=0;
        int max=0,j=0;
        for(int i=0;i<arr.length;i++){
            for(j=0;j<=i;j++){
                if(arr[j]>max)
                max=arr[j];
            }
            if(max<j)
            chunk++;
        }
        return chunk;
        
    }
}
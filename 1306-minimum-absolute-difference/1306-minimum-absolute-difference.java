class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>l=new ArrayList();
        int minDis=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            
                int dis=(arr[i+1]-arr[i]);
                minDis=Math.min(minDis,dis);
            
        }
        for(int i=0;i<arr.length-1;i++){
            
                if((arr[i+1]-arr[i])==minDis){
                    l.add(Arrays.asList(arr[i],arr[i+1]));

                }
            
        }
        return l;
        
    }
}
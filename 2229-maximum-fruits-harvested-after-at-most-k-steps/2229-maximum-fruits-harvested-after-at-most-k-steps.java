class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max=0,i=0,j=0,tmp=0;
        while(j<fruits.length){
            int jp=fruits[j][0];
            tmp+=fruits[j][1];

            while(i<=j&&(jp-fruits[i][0])+Math.min(Math.abs(fruits[i][0]-startPos),Math.abs(jp-startPos))>k){
                tmp-=fruits[i][1];
                i++;
            }
            max=Math.max(max,tmp);
            j++;
        }
        return max;
    }
}
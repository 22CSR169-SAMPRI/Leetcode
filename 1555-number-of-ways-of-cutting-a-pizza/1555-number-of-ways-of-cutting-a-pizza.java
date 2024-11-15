class Solution {
    int[][] apples;
    int m;int n;
    long[][][] dp;
    public int ways(String[] pizza, int k) {
        m=pizza.length;
        n=pizza[0].length();
        apples=new int[m+1][n+1];
        dp=new long[m+1][n+1][k+1];
        for(long[][] dd:dp)for(long[] d:dd)Arrays.fill(d,-1);
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                apples[i][j]=apples[i+1][j]+apples[i][j+1]-apples[i+1][j+1]+(pizza[i].charAt(j)=='A'?1:0);
            }
        }
        // System.out.println(Arrays.deepToString(apples));
        long ans=dfs(0,0,k-1);
        return (int)(ans%1000000007);
    }

    long dfs(int r,int c,int k){
        if(dp[r][c][k]!=-1)return dp[r][c][k];
        if(apples[r][c]==0)return 0;
        if(k==0){
            // System.out.println(r+"--"+c);
            return 1;
        }
        long ans=0;
        for(int i=r+1;i<m;i++){
            if(apples[r][c]-apples[i][c]>0){
                ans+=dfs(i,c,k-1);
            }
        }
        for(int j=c+1;j<n;j++){
            if(apples[r][c]-apples[r][j]>0){
                ans+=dfs(r,j,k-1);
            }
        }
        dp[r][c][k]=ans;
        return ans;
    }
}
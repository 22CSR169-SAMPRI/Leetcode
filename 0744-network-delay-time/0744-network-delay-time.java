import java.util.*;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<times.length;j++){
                int s=times[j][0];
                int d=times[j][1];
                int w=times[j][2];
                if(dist[s]!=Integer.MAX_VALUE && dist[s]+w<dist[d]){
                    dist[d]=dist[s]+w;
                }
            }
        }
        int max=dist[1];
        for(int i=1;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}
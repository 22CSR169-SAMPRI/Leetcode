class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length, n= mat[0].length;
        int l = m, r = 5000*m;


        while(l<r){
            int mid = l + (r-l)/2;

            if(count(mid, mat,0,0,k)<k){
                l = mid+1;
            } else{
                r = mid;
            }
        }
        return l ;
    }

    public int count(int guess,int[][] mat, int row, int total, int k){

        if(total > guess){
            return 0;
        }

        if(row == mat.length){
            if(total>guess){
                return 0;
            } else{
                return 1;
            }
        }

        int res = 0; //counting number of sums which are less then k

        for(int c = 0; c < mat[0].length; c++){
              if(total + mat[row][c] > guess)
                break;
            int  y = count(guess, mat, row+1, total+mat[row][c],k);
            if(y==0)// if we get 0 from sub tree break 
                break;
            res += y;
            if(res>=k) // if total count > k , no need break as we achieved what we are looking for hi=guess
                break;
        }
        return res;
    }
}
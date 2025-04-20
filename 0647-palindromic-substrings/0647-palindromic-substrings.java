class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            int odd=getA(s,i,i);
            int even=getA(s,i,i+1);
            
            //int max=Math.max(odd,even);
            count=count+odd+even;
        }
        return count;
        
    }
    public int getA(String str,int s,int e){
        int c=0;
        while(s>=0 && e<=str.length()-1 && str.charAt(s)==str.charAt(e)){
            s--;
            e++;
            c++;
        }
        return c;
    }
}
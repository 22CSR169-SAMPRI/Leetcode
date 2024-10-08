class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i<nums1.length; i++){
            st.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(st.contains(nums2[i])){
                li.add(nums2[i]);
                st.remove(nums2[i]);
            }
        }
        int [] ans = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            ans[i] = li.get(i);
        }
        return ans; 
    }
}
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0, sum = 0;
        for(Integer i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
         // max = Math.max(max, hm.get(i));
        }
        Set<Integer> keys = hm.keySet();
        for(Integer i : keys){
            max = Math.max(max, hm.get(i));
        }
        for(Integer i : keys){
            if(hm.get(i) == max) sum += hm.get(i);
        }
        return sum;
    }
}
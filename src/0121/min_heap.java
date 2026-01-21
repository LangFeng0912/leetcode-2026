class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            } else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for(Integer key: map.keySet()){
            int val = map.get(key);
            System.out.println(val);
            if(minHeap.size()<k){
                minHeap.add(new int[]{key, val});
            } else{
                if(val>minHeap.peek()[1]){
                    minHeap.poll();
                    minHeap.add(new int[]{key, val});
                }
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = minHeap.poll()[0];
        }

        return ans;
    }
}
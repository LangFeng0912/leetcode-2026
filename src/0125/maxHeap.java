class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((list1,list2) 
            -> list2.get(0) + list2.get(1) - list1.get(0) - list1.get(1)); 
        for(int i = 0; i < Math.min(nums1.length,k); i++){
            if(maxHeap.size() == k && (nums1[i] + nums2[0])>(maxHeap.peek().get(0) + maxHeap.peek().get(1))){
                break;
            }
            for(int j = 0; j<Math.min(nums2.length,k); j++){
                if(maxHeap.size() < k){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    maxHeap.add(list);
                }else{
                    int maxVal = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if(maxVal > nums1[i] + nums2[j]){
                        maxHeap.poll();
                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        maxHeap.add(list);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(maxHeap.poll());
        }
        return res;
    }
}
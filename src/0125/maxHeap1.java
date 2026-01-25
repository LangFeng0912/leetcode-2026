class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x1,x2) -> x2-x1);

        for(int i = 0; i< stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(!maxHeap.isEmpty()){
            int st1 = maxHeap.poll();
            if(maxHeap.isEmpty()){
                return st1;
            }
            int st2 = maxHeap.poll();
            if(st1>st2){
                maxHeap.add(st1-st2);
            }
        }
        
        return 0;
    }
}
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int timer = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<tickets.length; i++){
            queue.offer(new int[]{i, tickets[i]});
        }

        while(true){
            if(queue.peek()[0]==k && queue.peek()[1] == 1){
                return timer +1;
            }
            int[] cur = queue.poll();
            if (cur[1] != 1){
                int[] updated = new int[]{cur[0], cur[1]-1};
                queue.offer(updated);
            }
            timer++;
        }
        
    }
}
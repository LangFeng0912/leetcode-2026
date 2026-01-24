class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int n = students.length;

        for(int i = 0; i<n; i++){
            queue.offer(i);
        }

        int j = 0;
        while( j<n){
            if(!queue.isEmpty() && sandwiches[j] == students[queue.peek()]){
                queue.poll();
                j++;
            }else{
                int ops = 0;
                while(!queue.isEmpty() && sandwiches[j] != students[queue.peek()]
                && ops < n-j){
                    int index = queue.poll();
                    queue.offer(index);
                    ops++;               
                }
                if(ops == n-j){
                    return n-j;
                }
            }
        }

        return 0;
    }
}
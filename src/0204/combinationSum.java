class Solution {
    int sumVal;
    int setLength;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        sumVal = n;
        setLength = k;
        for(int i=1; i<=9; i++){
            backtrace(i);
        }
        return res;
    }

    public void backtrace(int node){
        if(getSum(path) > sumVal){
            return;
        }

        if(path.size() > setLength-1){
            return;
        }


        path.add(node);
        if(path.size() == setLength && getSum(path) == sumVal){
            res.add(new ArrayList<>(path));
            path.remove(path.size() -1);
            return;
        }

        int j = node +1;
        while(j<=sumVal-getSum(path) && j<=9){
            backtrace(j);
            j++;
        }

        path.remove(path.size() -1);

    }

    public int getSum(List<Integer> list){
        int sum = 0;
        for(Integer i:list){
            sum += i;
        }
        return sum;
    }

}
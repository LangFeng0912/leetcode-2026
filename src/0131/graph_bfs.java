class Solution {

    HashMap<String, List<String>> adj = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        adj.put(beginWord, new ArrayList<>());

        for(String word: wordList){
            adj.put(word, new ArrayList<>());
            for(String node: adj.keySet()){
                if(connected(word, node)){
                    adj.get(node).add(word);
                    adj.get(word).add(node);
                }
            }
        }

        return bfs(beginWord, endWord);


    }

    private int bfs(String begin, String end){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(begin);
        int ops = 1;

        while(!queue.isEmpty()){
            int k = queue.size();
            //注意要poll掉栈里的所有节点
            for(int i = 0; i<k; i++){
                String node = queue.poll();

                visited.add(node);
                if(node.equals(end)){
                    return ops;
                }

                for(String nextNode: adj.get(node)){
                    if(!visited.contains(nextNode)){
                        queue.offer(nextNode);
                    }
                }
            }
            ops++;
        }

        return 0;
    }

    private boolean connected(String word1, String word2){
        int i = 0;
        int n = word1.length();
        while(i<n && word1.charAt(i) == word2.charAt(i)){
                i++;
        }
        if(i==n){
            return false;
        }
        i++;
        while(i<n){
            if(word1.charAt(i) != word2.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
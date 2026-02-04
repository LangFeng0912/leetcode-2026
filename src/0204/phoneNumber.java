class Solution {
    HashMap<String, List<String>> mpa = new HashMap<>();
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    int n;
    String d;
    public List<String> letterCombinations(String digits) {
        mpa.put("2", Arrays.asList("a", "b", "c"));
        mpa.put("3", Arrays.asList("d", "e", "f"));
        mpa.put("4", Arrays.asList("g", "h", "i"));
        mpa.put("5", Arrays.asList("j", "k", "l"));
        mpa.put("6", Arrays.asList("m", "n", "o"));
        mpa.put("7", Arrays.asList("p", "q", "r", "s"));
        mpa.put("8", Arrays.asList("t", "u", "v"));
        mpa.put("9", Arrays.asList("w", "x", "y", "z"));

        n = digits.length();
        d = digits;

        for(String t: mpa.get(String.valueOf(d.charAt(0)))){
            backtrace(0, t);
        }

        return res;
    }

    public void backtrace(int index, String s){
        if(path.size() > n-1){
            return;
        }
        
        path.add(s);
        if (path.size() == n) {
            res.add(getString(path));
        }

        for(int i=index+1; i<n; i++){
            for(String t: mpa.get(String.valueOf(d.charAt(i)))){
                backtrace(i, t);
            }
        }

        path.remove(path.size()-1);

    }

    public String getString(List<String> list){
        StringBuilder strBuilder = new StringBuilder();
        for(String s: list){
            strBuilder.append(s);
        }
        return strBuilder.toString();
    }
}
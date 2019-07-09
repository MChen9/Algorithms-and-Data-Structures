class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
       
        List<Integer> path = new ArrayList();
        dfs(target, path, list, candidates, 0);
        
        return list;
    }
    
    private void dfs(int res, List<Integer> path, List<List<Integer>> list, int[] candidates, int start) {
        if (res >= 0) {
            if (res == 0) {
                list.add(new ArrayList<Integer>(path));
            } else {
                for (int c = start; c < candidates.length; c++) {
                    path.add(candidates[c]);
                    dfs(res - candidates[c], path, list, candidates, c);
                    path.remove(path.size() - 1);
                }
            }
        } 
        
    }
}

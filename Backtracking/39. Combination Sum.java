class Solution {
    /**
     * [Reference](https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))
     * Key Points:
     *   1. DFS
     *      1.1. Backtracking is slightly different from DFS, similar point is that go straight to the end
     *           then go back to parent level, but we need to track the current state so that we would not
     *           visit it again, e.g.
     *             candidates = [2,3,5], target = 8
     *                   2  3  5                            2  3  5
     *                  /                                   /
     *                 2                                   2
     *                /      --> go to upper level-->      /
     *               2                                    2
     *              /                                     /\ \
     *             2                                     2  3 5  <-- so we need to keep track the index of start
     *      1.2. Use remove() to backtrack
     *   2. Memorization
     *      2.1. We need to record every path that sum up to target on every iteration, so we use array to 
     *           store data
     *      2.2. If It meet the requirement, we add it to the final array of array, but need to create a new object
     *
     */
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
                list.add(new ArrayList<Integer>(path)); // create new object
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

class Solution {
    /**
     * [Reference I](https://www.youtube.com/watch?v=ZmnqCZp9bBs)
     * [Reference II](https://www.youtube.com/watch?v=g8bSdXCG-lA)
     * DP + Stack
     * Key points:
     *   1. Regards every row as a baseline of histogram, and add 1 to the corresponding
     *      height in heights array
     *      e.g. ["1","0","1","0","0"]    |    heights [1, 0, 1, 0, 0]  -> maxArea = 1
     *           ["1","0","1","1","1"]    |            [2, 0, 2, 1, 1]  -> maxArea = 2 
     *           ["1","1","1","1","1"]    |            [3, 1, 3, 2, 1]        ...
     *           ["1","0","0","1","0"]    +            [4, 0, 0, 3, 0]        ...
     *    2. Calculate max area of every subhistogram by employing algorithm in 
     *       84. Largest Rectangle in Histogram
     *       (https://github.com/MChen9/Algorithms-and-Data-Structures/blob/master/Stack/84.%20Largest%20Rectangle%20in%20Histogram.java)
     *
     * Time Complexity: O(NM). Running leetcode84 on each row takes M (length of each row) time. 
     * This is done N times for O(NM)O(NM).
     * Space Complexity: O(M).We allocate an array the size of the the number of columns to 
     * store our widths at each row. 
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] row: matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1')
                    heights[i]++;
                else
                    heights[i] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(0);
        int top = 0, maxArea = heights[0];
        for (int i = 1; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length ||
                   heights[i] <= heights[stack.peekFirst()])) {
                top = heights[stack.pollFirst()];
                if (stack.isEmpty())
                    maxArea = Math.max(maxArea, top * i);
                else
                    maxArea = Math.max(maxArea, top * 
                                       (i - stack.peekFirst() - 1));
            }
            stack.offerFirst(i);
        }
        return maxArea;
    }
}

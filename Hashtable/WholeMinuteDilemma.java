import java.util.*;

class WholeMinuteDilemma {
    /**
     * Key points:
     *   1. Similar to Two Sum
     *      1.1. Before storing to hashmap, use % to have remainder,
     *           since (key + num) % 60 == 0, so we need to substract 
     *           both of them
     *      1.2. There may be some duplicates, so value is used for storing
     *           #occurrency, so the result only need to add the #occurrency
     *
     * Time Complexity: O(n), one pass
     * Space Complexity: O(1), on more than 60 , so O(60)
     */
    static int playList(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: array) {
            num %= 60;
            if (map.containsKey(60 - num)) {
                res += map.get(60 - num);
            }
            
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 50, 90, 30}; //10, 50, 90, 30, {30, 30, 30}, {10, 20, 20, 40, 50, 100}
        System.out.println(playList(arr));
    }
}

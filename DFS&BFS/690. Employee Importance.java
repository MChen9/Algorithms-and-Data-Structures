/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    /**
     * Key Points:
     *   Use hashmap to record relations of ID and Employees, since we need to find 
     *   an entry(root) of the tree and the subordinates objects
     *
     * Time Complexity: O(N), where N is the number of employees. We might query each employee in BFS
     * Space Complexity: O(N)
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int ipt = 0;
        while (!queue.isEmpty()) {
            Employee temp = queue.poll();
            ipt += temp.importance;
            if (!temp.subordinates.isEmpty()) {
                for (int sub:temp.subordinates) {
                    queue.offer(map.get(sub)); // subordinates is an array of int
                }
            }
        }
        return ipt;
    }
}

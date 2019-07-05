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
                    queue.offer(map.get(sub));
                }
            }
        }
        return ipt;
    }
}

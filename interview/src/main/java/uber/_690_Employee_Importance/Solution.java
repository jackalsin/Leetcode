package uber._690_Employee_Importance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int getImportance(List<Employee> employees, int id) {
    final Map<Integer, Employee> employeeHashMap = new HashMap<>();
    employees.forEach(employee -> employeeHashMap.put(employee.id, employee));
    return getImportance(employeeHashMap, id);
  }

  private int getImportance(Map<Integer, Employee> employeeHashMap, int id) {
    int result = employeeHashMap.get(id).importance;
    for (final int employeeId : employeeHashMap.get(id).subordinates) {
      result += getImportance(employeeHashMap, employeeId);
    }
    return result;
  }


  class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
  }

}

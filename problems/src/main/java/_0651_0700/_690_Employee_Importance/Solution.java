package _0651_0700._690_Employee_Importance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/6/2018.
 */
public class Solution {
  public int getImportance(List<Employee> employees, int id) {
    final Map<Integer, Employee> idToEmployee = new HashMap<>();
    for (final Employee employee : employees) {
      idToEmployee.put(employee.id, employee);
    }
    return getImportance(idToEmployee, id);
  }

  private int getImportance(Map<Integer, Employee> employees, int id) {
    int sum = employees.get(id).importance;
    final Employee employee = employees.get(id);
    for (final int sub : employee.subordinates) {
      sum += getImportance(employees, sub);
    }
    return sum;
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

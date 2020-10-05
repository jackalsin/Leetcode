USE leetcode;
SELECT e1.Name AS Employee FROM Employee e1 LEFT JOIN Employee e2 ON(e2.Id = e1.ManagerId) WHERE e1.ManagerId IS NOT NULL AND e1.Salary > e2.Salary;

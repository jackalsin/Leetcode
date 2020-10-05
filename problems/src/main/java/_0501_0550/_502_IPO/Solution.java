package _0501_0550._502_IPO;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  /**
   * 31 / 31 test cases passed.
   * Status: Accepted
   * Runtime: 49 ms
   * <p>
   * Time Complexity: O(NlogN)
   * Space Complexity: O(N)
   *
   * @param k
   * @param W
   * @param Profits
   * @param Capital
   * @return
   */
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    final PriorityQueue<Project> allProject = new PriorityQueue<>(new Comparator<>() {
      @Override
      public int compare(Project o1, Project o2) {
        return Integer.compare(o1.capital, o2.capital);
      }
    });

    for (int i = 0; i < Profits.length; i++) {
      allProject.add(new Project(Profits[i], Capital[i]));
    }

    final Queue<Project> validCandidates = new PriorityQueue<>(new Comparator<>() {

      @Override
      public int compare(Project o1, Project o2) {
        return Integer.compare(o2.profit, o1.profit);
      }
    });

    while (k-- > 0) {
      // add to valid
      while (!allProject.isEmpty() && allProject.peek().capital <= W) {
        validCandidates.add(allProject.remove());
      }
      if (validCandidates.isEmpty()) {
        continue;
      }
      // get the most profitable one.
      final Project doThisProject = validCandidates.remove();
      W += doThisProject.profit;
    }
    return W;
  }

  private static final class Project {
    private final int profit, capital;

    private Project(int profit, int capital) {
      this.profit = profit;
      this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Project project = (Project) o;
      return profit == project.profit &&
          capital == project.capital;
    }

    @Override
    public int hashCode() {

      return Objects.hash(profit, capital);
    }

    @Override
    public String toString() {
      return "Project{" +
          "profit=" + profit +
          ", capital=" + capital +
          '}';
    }
  }
}

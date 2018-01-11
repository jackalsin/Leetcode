package interviews.google.reservoir_sampling._382_Linked_List_Random_Node;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.ListNode;
import utils.ListNodes;

/**
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] base = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
    final ListNode head = ListNodes.getListOfNodes(base);
    int[] occurs = new int[base.length];
    final int total = 300_000;
    solution = new Solution(head);
    for (int i = 0; i < total; i++) {
      occurs[solution.getRandom()]++;
    }
    final double[] chances = new double[base.length];
    for (int i = 0; i < base.length; i++) {
      chances[i] = (double) occurs[i] / (double) total;
    }
    System.out.println(Arrays.toString(chances));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] base = new int[] {10, 1, 10, 200};
    final ListNode head = ListNodes.getListOfNodes(base);
    Map<Integer, Integer> counts = new HashMap<>();
    final int total = 300_000;
    solution = new Solution(head);
    for (int i = 0; i < total; i++) {
      int res = solution.getRandom();
      counts.put(res, counts.getOrDefault(res, 0) + 1);
    }
    System.out.println(counts);
  }

}

package interviews.linkedin._382_Linked_List_Random_Node;

import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private static final double BIAS = 1E-3;

  @Test
  void testOnlineCase1() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{0, 1, 2});
    final int[] counts = new int[3];
    final Solution solution = new SolutionI(head);
    final int total = 1_000_000_000;
    for (int i = 0; i < total; i++) {
      counts[solution.getRandom()]++;
    }
    final double expected = 1d / 3;
    System.out.println(Arrays.toString(counts));
    for (int c : counts) {
      final double actual = c / (double) total;
      assertEquals(expected, actual, BIAS);
    }

  }
}
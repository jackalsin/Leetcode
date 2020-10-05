package linkedin._382_Linked_List_Random_Node;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
class ReservoirSamplingSolutionTest {


  private static final double BIAS = 1E-3;

  @Test
  void testOnlineCase1() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{0, 1, 2});
    final int[] counts = new int[3];
    final Solution solution = new ReservoirSamplingSolution(head);
    final int total = 1_000_000_000;
    for (int i = 0; i < total; i++) {
      counts[solution.getRandom()]++;
    }
    final double expected = 1d / 3;
    for (int c : counts) {
      final double actual = c / (double) total;
      assertEquals(expected, actual, BIAS);
    }
  }

  @Test
  void testOnlineCase2() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{10, 1, 10, 20, 100});
    final Map<Integer, Double> actual = new HashMap<>(),
        expected = Map.of(
            10, 0.4d,
            1, 0.2d,
            100, 0.2d,
            20, 0.2d
        );
    final Solution solution = new ReservoirSamplingSolution(head);
    final int total = 1_000_000_000;
    for (int i = 0; i < total; i++) {
      final int key = solution.getRandom();
      actual.put(key, actual.getOrDefault(key, 0d) + 1);
    }
    for (final Map.Entry<Integer, Double> e : actual.entrySet()) {
      final int key = e.getKey();
      final double prob = e.getValue() / total;
      assertEquals(expected.get(key), prob, BIAS);
    }
  }
}
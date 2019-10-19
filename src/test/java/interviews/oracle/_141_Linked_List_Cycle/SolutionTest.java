package interviews.oracle._141_Linked_List_Cycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/19/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNoCycle0(Solution solution) {
    assertFalse(solution.hasCycle(null));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNoCycle1(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(new int[]{1});
    assertFalse(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNoCycle2(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2});
    assertFalse(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testCycle1(Solution solution) {
    ListNode head = new ListNode(1);
    head.next = head;
    assertTrue(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testCycle2(Solution solution) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    assertTrue(solution.hasCycle(head));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
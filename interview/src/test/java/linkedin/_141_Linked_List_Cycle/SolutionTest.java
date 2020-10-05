package linkedin._141_Linked_List_Cycle;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNoCycle0(Solution solution) {
    assertFalse(solution.hasCycle(null));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNoCycle1(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(new int[]{1});
    assertFalse(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNoCycle2(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2});
    assertFalse(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testCycle1(Solution solution) {
    ListNode head = new ListNode(1);
    head.next = head;
    assertTrue(solution.hasCycle(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testCycle2(Solution solution) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    assertTrue(solution.hasCycle(head));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
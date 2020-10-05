package oracle._019_Remove_Nth_Node_From_End_of_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseNull(Solution solution) {
    final ListNode head = null;
    assertNull(solution.removeNthFromEnd(head, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseRemoveMid(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5),
        actual = solution.removeNthFromEnd(head, 2),
        expected = ListNodes.getListOfNodes(1, 2, 3, 5);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineRemoveHead(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5),
        actual = solution.removeNthFromEnd(head, 5),
        expected = ListNodes.getListOfNodes(2, 3, 4, 5);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testRemoveTail(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5),
        actual = solution.removeNthFromEnd(head, 1),
        expected = ListNodes.getListOfNodes(1, 2, 3, 4);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
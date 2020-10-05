package pureStorage._0203_Remove_Linked_List_Elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testRemoveLast(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4});
    assertEquals(expected, solution.removeElements(head, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testRemoveFirst(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{2, 6, 3, 4, 5});
    assertEquals(expected, solution.removeElements(head, 1));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
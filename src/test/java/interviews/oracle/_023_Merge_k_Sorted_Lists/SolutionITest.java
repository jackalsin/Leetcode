package interviews.oracle._023_Merge_k_Sorted_Lists;

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
  @MethodSource("solutionProvider")
  void testWithAllNull(Solution solution) {
    final ListNode[] input = new ListNode[]{null, null};
    assertNull(solution.mergeKLists(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithEqualLength(Solution solution) {
    final ListNode node1 = ListNodes.getListOfNodes(new int[]{1, 5, 7});
    final ListNode node2 = ListNodes.getListOfNodes(new int[]{2, 4, 6});
    final ListNode node3 = ListNodes.getListOfNodes(new int[]{3, 6, 8});
    final ListNode[] input = new ListNode[]{node1, node2, node3};
    final ListNode result = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8});
    assertEquals(result, solution.mergeKLists(input));
  }
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new PqSolution()
    );
  }
}
package tableau._023_Merge_k_Sorted_Lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final ListNode[] head = {
        ListNodes.getListOfNodes(1, 4, 5),
        ListNodes.getListOfNodes(1, 3, 4),
        ListNodes.getListOfNodes(2, 6)
    };
    final ListNode expect = ListNodes.getListOfNodes(
        1, 1, 2, 3, 4, 4, 5, 6
    ), actual = solution.mergeKLists(head);
    assertEquals(expect, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution(),
        new O1Solution()
    );
  }
}
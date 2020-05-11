package interviews.oracle._024_Swap_Nodes_in_Pairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOddList(Solution solution) {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 3, 5});
    final ListNode result = ListNodes.getListOfNodes(new int[]{3, 1, 5});
    assertEquals(result, solution.swapPairs(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithEvenList(Solution solution) {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4});
    final ListNode result = ListNodes.getListOfNodes(new int[]{2, 1, 4, 3});
    assertEquals(result, solution.swapPairs(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
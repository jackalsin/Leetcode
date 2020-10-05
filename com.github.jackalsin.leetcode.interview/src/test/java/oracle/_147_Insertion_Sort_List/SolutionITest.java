package oracle._147_Insertion_Sort_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    solution.insertionSortList(null);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Solution solution) {
    final ListNode input = ListNodes.getListOfNodes(2);
    final ListNode expected = ListNodes.getListOfNodes(2);
    assertEquals(expected, solution.insertionSortList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test5Element(Solution solution) {
    final ListNode input = ListNodes.getListOfNodes(4, 3, 1, 2, 5);
    final ListNode expected = ListNodes.getListOfNodes(1, 2, 3, 4, 5);
    assertEquals(expected, solution.insertionSortList(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
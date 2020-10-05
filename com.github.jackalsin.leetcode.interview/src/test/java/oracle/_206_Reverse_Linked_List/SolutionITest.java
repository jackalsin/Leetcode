package oracle._206_Reverse_Linked_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2});
    ListNode expected = ListNodes.getListOfNodes(new int[]{2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testThreeElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    ListNode expected = ListNodes.getListOfNodes(new int[]{3, 2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
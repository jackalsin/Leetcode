package _0201_0250._206_Reverse_Linked_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOneElement(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(1);
    ListNode expected = ListNodes.getListOfNodes(1);
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(1, 2);
    ListNode expected = ListNodes.getListOfNodes(2, 1);
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testThreeElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(1, 2, 3);
    ListNode expected = ListNodes.getListOfNodes(3, 2, 1);
    assertEquals(expected, solution.reverseList(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}
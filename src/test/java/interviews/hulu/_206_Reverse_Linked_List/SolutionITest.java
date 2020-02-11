package interviews.hulu._206_Reverse_Linked_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOneElement(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2});
    ListNode expected = ListNodes.getListOfNodes(new int[]{2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testThreeElements(Solution solution) {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    ListNode expected = ListNodes.getListOfNodes(new int[]{3, 2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
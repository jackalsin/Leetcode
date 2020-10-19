package _1001_1050._1019_Next_Greater_Node_In_Linked_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(2, 1, 5);
    final int expected[] = {5, 5, 0}, actual[] = solution.nextLargerNodes(head);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(2, 7, 4, 3, 5);
    final int expected[] = {7, 0, 5, 5, 0}, actual[] = solution.nextLargerNodes(head);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 7, 5, 1, 9, 2, 5, 1);
    final int expected[] = {7, 9, 9, 9, 0, 5, 0, 0}, actual[] = solution.nextLargerNodes(head);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
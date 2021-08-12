package _0301_0350._328_Odd_Even_Linked_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/29/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5);
    final ListNode expected = ListNodes.getListOfNodes(1, 3, 5, 2, 4);
    assertEquals(expected, solution.oddEvenList(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes();
    final ListNode expected = ListNodes.getListOfNodes();
    assertEquals(expected, solution.oddEvenList(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSingle(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1);
    final ListNode expected = ListNodes.getListOfNodes(1);
    assertEquals(expected, solution.oddEvenList(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Nodes(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2);
    final ListNode expected = ListNodes.getListOfNodes(1, 2);
    assertEquals(expected, solution.oddEvenList(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNormalEven(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5, 6);
    final ListNode expected = ListNodes.getListOfNodes(1, 3, 5, 2, 4, 6);
    assertEquals(expected, solution.oddEvenList(head));
  }

}

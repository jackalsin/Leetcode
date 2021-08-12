package _0101_0150._143_Reorder_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(1);
    ListNode expected = ListNodes.getListOfNodes(1);
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(1, 2);
    ListNode expected = ListNodes.getListOfNodes(1, 2);
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(1, 2, 3);
    ListNode expected = ListNodes.getListOfNodes(1, 3, 2);
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test4(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4);
    ListNode expected = ListNodes.getListOfNodes(1, 4, 2, 3);
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test5(Solution solution) {
    ListNode head = ListNodes.getListOfNodes(1, 2, 3, 4, 5);
    ListNode expected = ListNodes.getListOfNodes(1, 5, 2, 4, 3);
    solution.reorderList(head);
    assertEquals(expected, head);
  }
}

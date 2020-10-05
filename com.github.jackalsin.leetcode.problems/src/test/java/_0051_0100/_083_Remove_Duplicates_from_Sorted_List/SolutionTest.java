package _0051_0100._083_Remove_Duplicates_from_Sorted_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/19/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testNoDup(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(input);
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testLeadingDup(Solution solution) {
    final int[] input = new int[]{1, 1, 1, 2, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTailingDup(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 3, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testContiousDup(Solution solution) {
    final int[] input = new int[]{2, 2, 3, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode actual = solution.deleteDuplicates(head);
    assertEquals(ListNodes.getListOfNodes(new int[]{2, 3}), solution.deleteDuplicates(head));
  }
}

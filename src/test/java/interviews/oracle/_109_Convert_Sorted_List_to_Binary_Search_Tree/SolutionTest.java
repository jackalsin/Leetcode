package interviews.oracle._109_Convert_Sorted_List_to_Binary_Search_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.TreeNode;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {

  static Stream<Solution> solutionStream() throws Exception {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test0Element(Solution solution) {
    assertEquals(null, solution.sortedListToBST(null));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Element(Solution solution) {
    assertEquals(new TreeNode(1), solution.sortedListToBST(new ListNode(1)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Element(Solution solution) {
    ListNode inputHead = new ListNode(1);
    inputHead.next = new ListNode(2);
    TreeNode expected1 = new TreeNode(2);
    expected1.left = new TreeNode(1);
    TreeNode expected2 = new TreeNode(1);
    expected2.right = new TreeNode(2);
    final Set<TreeNode> expected = Set.of(
        expected1, expected2);
    TreeNode actual = solution.sortedListToBST(inputHead);
    assertTrue(expected.contains(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3Element(Solution solution) {
    ListNode inputHead = new ListNode(1);
    inputHead.next = new ListNode(2);
    inputHead.next.next = new ListNode(3);
    TreeNode expected = new TreeNode(2);
    expected.left = new TreeNode(1);
    expected.right = new TreeNode(3);
    assertEquals(expected, solution.sortedListToBST(inputHead));
  }

}
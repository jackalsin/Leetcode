package _0101_0150._109_Convert_Sorted_List_to_Binary_Search_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/19/2017.
 */

class SolutionTest {

  static Stream<Solution> solutionProvider() throws Exception {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test0Element(Solution solution) {
    assertEquals(null, solution.sortedListToBST(null));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1Element(Solution solution) {
    assertEquals(new TreeNode(1), solution.sortedListToBST(new ListNode(1)));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2Element(Solution solution) {
    ListNode inputHead = new ListNode(1);
    inputHead.next = new ListNode(2);
    TreeNode expected = new TreeNode(2);
    expected.left = new TreeNode(1);
    assertEquals(expected, solution.sortedListToBST(inputHead));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
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
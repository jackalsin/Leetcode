package interviews.uber._021_Merge_Two_Sorted_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.ListNodes.getListOfNodes;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testTwoEqualLengthList() throws Exception {
    final ListNode sampleAns = getListOfNodes(new int[]{1, 2, 3, 4, 5, 6});
    final ListNode left = getListOfNodes(new int[]{1, 3, 5});
    final ListNode right = getListOfNodes(new int[]{2, 4, 6});
    assertEquals(sampleAns, solution.mergeTwoLists(left, right));
  }

  @Test
  void testWith1And3() throws Exception {
    final ListNode sampleAns = getListOfNodes(new int[]{0, 1, 2, 4});
    final ListNode left = getListOfNodes(new int[]{1});
    final ListNode right = getListOfNodes(new int[]{0, 2, 4});
    assertEquals(sampleAns, solution.mergeTwoLists(left, right));
  }
}
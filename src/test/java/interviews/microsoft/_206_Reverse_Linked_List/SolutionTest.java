package interviews.microsoft._206_Reverse_Linked_List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOneElement() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.reverseList(input));
  }

  @Test
  void testTwoElements() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2});
    ListNode expected = ListNodes.getListOfNodes(new int[]{2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  @Test
  void testThreeElements() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    ListNode expected = ListNodes.getListOfNodes(new int[]{3, 2, 1});
    assertEquals(expected, solution.reverseList(input));
  }


}
package _701_750._725_Split_Linked_List_in_Parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    final ListNode[] expected = {new ListNode(1), new ListNode(2), new ListNode(3), null, null},
        actual = solution.splitListToParts(head, 5);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    final ListNode[] expected = {
        ListNodes.getListOfNodes(new int[]{1, 2, 3, 4}),
        ListNodes.getListOfNodes(new int[]{5, 6, 7}),
        ListNodes.getListOfNodes(new int[]{8, 9, 10}),
    }, actual = solution.splitListToParts(head, 3);
    assertArrayEquals(expected, actual);
  }
}
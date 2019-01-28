package interviews.airbnb._160_Intersection_of_Two_Linked_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class BothMoveTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BothMove();
  }

  @Test
  void testOnlineCase() {
    ListNode headA = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode headB = ListNodes.getListOfNodes(new int[]{-1, -2, -3});
    headB.next.next.next = headA.next.next;
    assertEquals(headA.next.next, solution.getIntersectionNode(headA, headB));
  }

  @Test
  void testOnlineCase2() {
    ListNode headA = ListNodes.getListOfNodes(new int[]{2, 6, 4});
    ListNode headB = ListNodes.getListOfNodes(new int[]{1, 5});
    assertNull(solution.getIntersectionNode(headA, headB));
  }

}
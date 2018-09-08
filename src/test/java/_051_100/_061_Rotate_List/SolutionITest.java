package _051_100._061_Rotate_List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testWith5And2() {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode expected = ListNodes.getListOfNodes(new int[]{4, 5, 1, 2, 3});
    assertEquals(expected, solution.rotateRight(head, 2));
  }

  @Test
  void testWith5And7() {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode expected = ListNodes.getListOfNodes(new int[]{4, 5, 1, 2, 3});
    assertEquals(expected, solution.rotateRight(head, 7));
  }

  @Test
  void testWith0And0() {
    ListNode head = null;
    ListNode expected = null;
    assertEquals(expected, solution.rotateRight(head, 0));
  }

  @Test
  void testWith1And1() {
    ListNode head = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.rotateRight(head, 1));
  }

}

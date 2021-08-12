package _0201_0250._203_Remove_Linked_List_Elements;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testRemoveLast() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4});
    assertEquals(expected, solution.removeElements(head, 5));
  }

  @Test
  public void testRemoveFirst() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 6, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{2, 6, 3, 4, 5});
    assertEquals(expected, solution.removeElements(head, 1));
  }
}

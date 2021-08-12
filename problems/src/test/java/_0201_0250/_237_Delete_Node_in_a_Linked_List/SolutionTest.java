package _0201_0250._237_Delete_Node_in_a_Linked_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[] {1, 2, 3, 4});
    ListNode excepted = ListNodes.getListOfNodes(new int[] {1, 2, 4});
    solution.deleteNode(head.next.next);
    assertEquals(excepted, head);
  }

}

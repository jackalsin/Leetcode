package interviews.facebook._025_Reverse_Nodes_in_k_Group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  private final int[] ARRAY = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }


  @Test
  void testWithK1() {
    final ListNode rtnHead = ListNodes.getListOfNodes(ARRAY);
    assertEquals(ListNodes.getListOfNodes(ARRAY), solution.reverseKGroup(rtnHead, 1));
  }

  @Test
  void testWithK3() {
    final ListNode stdHead = ListNodes.getListOfNodes(new int[]{3, 2, 1, 6, 5, 4, 9, 8, 7});
    final ListNode rtnHead = ListNodes.getListOfNodes(ARRAY);
    assertEquals(stdHead, solution.reverseKGroup(rtnHead, 3));
  }

}
package _0801_0850._817_Linked_List_Components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnePassSolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new OnePassSolution();
  }

  @Test
  void testOnlineCase1() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{0, 1, 2, 3});
    final int[] G = {0, 1, 3};
    assertEquals(2, solution.numComponents(head, G));
  }

  @Test
  void testOnlineCase2() {
    final ListNode head = ListNodes.getListOfNodes(new int[]{0, 1, 2, 3, 4});
    final int[] G = {0, 3, 1, 4};
    assertEquals(2, solution.numComponents(head, G));
  }
}
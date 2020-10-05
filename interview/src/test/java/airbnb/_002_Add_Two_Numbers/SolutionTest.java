package airbnb._002_Add_Two_Numbers;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final ListNode l1 = ListNodes.getListOfNodes(new int[]{2, 4, 3}),
        l2 = ListNodes.getListOfNodes(new int[]{5, 6, 4}),
        expected = ListNodes.getListOfNodes(new int[]{7, 0, 8}),
        actual = solution.addTwoNumbers(l1, l2);
    assertEquals(expected, actual);
  }
}
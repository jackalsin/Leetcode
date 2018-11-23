package _0201_0250._206_Reverse_Linked_List;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.reverseList(input));
  }

  @Test
  public void testTwoElements() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2});
    ListNode expected = ListNodes.getListOfNodes(new int[]{2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

  @Test
  public void testThreeElements() {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    ListNode expected = ListNodes.getListOfNodes(new int[]{3, 2, 1});
    assertEquals(expected, solution.reverseList(input));
  }

}
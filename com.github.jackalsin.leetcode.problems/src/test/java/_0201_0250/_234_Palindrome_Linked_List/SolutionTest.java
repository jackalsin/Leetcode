package _0201_0250._234_Palindrome_Linked_List;

import org.junit.Before;
import org.junit.Test;
import definition.ListNode;
import definition.ListNodes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOneElement() throws Exception {
    ListNode input = new ListNode(1);
    assertTrue(solution.isPalindrome(input));
  }

  @Test
  public void testTwoElementsNegative() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[]{1, 2});
    assertFalse(solution.isPalindrome(input));
  }

  @Test
  public void testTwoElementsPositive() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[]{2, 2});
    assertTrue(solution.isPalindrome(input));
  }
}
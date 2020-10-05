package _0101_0150._148_Sort_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(null, solution.sortList(null));
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(new ListNode(1), solution.sortList(new ListNode(1)));
  }

  @Test
  public void testTwoElement() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[]{2, 1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2});
    assertEquals(expected, solution.sortList(input));
  }

  @Test
  public void testThreeElement() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[]{3, 2, 1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    assertEquals(expected, solution.sortList(input));
  }

  @Test
  public void testFourElement() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[]{3, 2, 4, 1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4});
    assertEquals(expected, solution.sortList(input));
  }
}

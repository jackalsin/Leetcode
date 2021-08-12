package _0351_0400._369_Plus_One_Linked_List;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/7/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    ListNode expected = ListNodes.getListOfNodes(new int[] {1, 2, 4});
    ListNode input = ListNodes.getListOfNodes(new int[] {1, 2, 3});
    ListNode actual = solution.plusOne(input);

    assertEquals(expected, actual);
  }

  @Test
  public void test99() throws Exception {
    ListNode input = ListNodes.getListOfNodes(new int[] {9, 9});
    ListNode expected = ListNodes.getListOfNodes(new int[] {1, 0, 0});
    ListNode actual = solution.plusOne(input);

    assertEquals(expected, actual);
  }

}

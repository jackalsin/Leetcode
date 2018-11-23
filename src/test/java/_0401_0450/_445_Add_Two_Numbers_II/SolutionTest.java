package _0401_0450._445_Add_Two_Numbers_II;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new ReverseSolution();
    solution = new ReverseResultNotInPlace();
  }

  @Test
  public void test13And22() throws Exception {
    ListNode l1 = ListNodes.getListOfNodes(new int[] {1, 3});
    ListNode l2 = ListNodes.getListOfNodes(new int[] {2, 2});
    assertEquals(ListNodes.getListOfNodes(new int[] {3, 5}), solution.addTwoNumbers(l1, l2));
  }

  @Test
  public void test19And23() throws Exception {
    ListNode l1 = ListNodes.getListOfNodes(new int[] {1, 9});
    ListNode l2 = ListNodes.getListOfNodes(new int[] {2, 3});
    assertEquals(ListNodes.getListOfNodes(new int[] {4, 2}), solution.addTwoNumbers(l1, l2));
  }

  @Test
  public void test85And77() throws Exception {
    ListNode l1 = ListNodes.getListOfNodes(new int[] {8, 5});
    ListNode l2 = ListNodes.getListOfNodes(new int[] {7, 7});
    assertEquals(ListNodes.getListOfNodes(new int[] {1, 6, 2}), solution.addTwoNumbers(l1, l2));
  }

  @Test
  public void testFailedCase1And99() throws Exception {
    ListNode l1 = ListNodes.getListOfNodes(new int[] {1});
    ListNode l2 = ListNodes.getListOfNodes(new int[] {9, 9});
    assertEquals(ListNodes.getListOfNodes(new int[] {1, 0, 0}), solution.addTwoNumbers(l1, l2));
  }

  @Test
  public void testFailedCase99And8() throws Exception {
    ListNode l1 = ListNodes.getListOfNodes(new int[] {9, 9});
    ListNode l2 = ListNodes.getListOfNodes(new int[] {8});
    assertEquals(ListNodes.getListOfNodes(new int[] {1, 0, 7}), solution.addTwoNumbers(l1, l2));
  }

  //----- test reversion
  @Test
  public void testOneNode() throws Exception {
    final ListNode l1 = ListNodes.getListOfNodes(new int[] {1});
    assertEquals(new ListNode(1), new ReverseSolution().reverse(l1));
  }

  @Test
  public void test3Nodes() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[] {1, 2, 3});
    final ListNode expected = ListNodes.getListOfNodes(new int[] {3, 2, 1});
    assertEquals(expected, new ReverseSolution().reverse(head));
  }

  @Test
  public void test99() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[] {9, 9});
    final ListNode expected = ListNodes.getListOfNodes(new int[] {9, 9});
    assertEquals(expected, new ReverseSolution().reverse(head));
  }
}

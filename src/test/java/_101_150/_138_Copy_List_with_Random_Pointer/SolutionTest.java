package _101_150._138_Copy_List_with_Random_Pointer;

import org.junit.Before;
import org.junit.Test;

import utils.RandomListNode;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(null, solution.copyRandomList(null));
  }

  @Test
  public void test1Element() throws Exception {
    RandomListNode head = new RandomListNode(1);
    solution.copyRandomList(head);
  }

  @Test
  public void test1ElementWithRandom() throws Exception {
    RandomListNode head = new RandomListNode(1);
    head.random = head;
    solution.copyRandomList(head);
  }

  @Test
  public void test2Element() throws Exception {

  }
}

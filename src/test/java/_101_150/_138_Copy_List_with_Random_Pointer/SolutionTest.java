package _101_150._138_Copy_List_with_Random_Pointer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.RandomListNode;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    assertEquals(null, solution.copyRandomList(null));
  }

  @Test
  void test1Element() throws Exception {
    RandomListNode head = new RandomListNode(1);
    solution.copyRandomList(head);
  }

  @Test
  void test1ElementWithRandom() throws Exception {
    RandomListNode head = new RandomListNode(1);
    head.random = head;
    solution.copyRandomList(head);
  }

  @Test
  void test2Element() throws Exception {

  }
}

package _0101_0150._138_Copy_List_with_Random_Pointer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._138_Copy_List_with_Random_Pointer.Node;

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
    Node head = new Node(1);
    solution.copyRandomList(head);
  }

  @Test
  void test1ElementWithRandom() throws Exception {
    Node head = new Node(1);
    head.random = head;
    solution.copyRandomList(head);
  }

  @Test
  void test2Element() throws Exception {

  }
}

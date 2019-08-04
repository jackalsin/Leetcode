package interviews.uber._138_Copy_List_with_Random_Pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._138_Copy_List_with_Random_Pointer.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    assertEquals(null, solution.copyRandomList(null));
  }

  @Test
  void test1Element() {
    Node head = new Node(1);
    solution.copyRandomList(head);
  }

  @Test
  void test1ElementWithRandom() {
    Node head = new Node(1);
    head.random = head;
    solution.copyRandomList(head);
  }

}
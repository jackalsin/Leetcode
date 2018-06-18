package interviews.linkedin._023_Merge_k_Sorted_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    //[[1,4,5],[1,3,4],[2,6]]
    final ListNode[] list = {new ListNode(1), new ListNode(1), new ListNode(2)};
    list[0].next = new ListNode(4);
    list[0].next.next = new ListNode(5);
    list[1].next = new ListNode(3);
    list[1].next.next = new ListNode(4);
    list[2].next = new ListNode(6);

    final ListNode actual = solution.mergeKLists(list);
    final int[] expectedValue = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
    final ListNode expectedDummy = new ListNode(-1);
    ListNode cur = expectedDummy;
    for (int val : expectedValue) {
      cur.next = new ListNode(val);
      cur = cur.next;
    }

    assertEquals(expectedDummy.next, actual);
  }
}
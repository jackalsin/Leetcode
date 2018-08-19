package interviews.microsoft.noodleEssence.wrongPointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final DoubleLinkedListNode head = DoubleLinkedListNodes.get(1, 2, 3, 4, 5, 6);
    head.next.next.next.next.prev = head.next;
    final List<Integer> actual = solution.inorder(head);
    final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final DoubleLinkedListNode head = DoubleLinkedListNodes.get(1, 2, 3, 4, 5, 6);
    head.next.next.next = head.next.next.next.next.next;
    final List<Integer> actual = solution.inorder(head);
    final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

    assertEquals(expected, actual);
  }
}
package interviews.airbnb._147_Insertion_Sort_List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testEmpty() throws Exception {
    solution.insertionSortList(null);
  }

  @Test
  void testOneElement() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{2});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{2});
    assertEquals(expected, solution.insertionSortList(input));
  }

  @Test
  void test5Element() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{4, 3, 1, 2, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    assertEquals(expected, solution.insertionSortList(input));
  }

}
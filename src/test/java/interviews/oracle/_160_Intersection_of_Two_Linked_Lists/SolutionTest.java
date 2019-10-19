package interviews.oracle._160_Intersection_of_Two_Linked_Lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 10/18/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    ListNode headA = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode headB = ListNodes.getListOfNodes(new int[]{-1, -2, -3});
    headB.next.next.next = headA.next.next;
    assertEquals(headA.next.next, solution.getIntersectionNode(headA, headB));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    ListNode headA = ListNodes.getListOfNodes(new int[]{2, 6, 4});
    ListNode headB = ListNodes.getListOfNodes(new int[]{1, 5});
    assertNull(solution.getIntersectionNode(headA, headB));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }

}
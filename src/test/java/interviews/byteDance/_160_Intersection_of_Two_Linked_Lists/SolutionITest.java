package interviews.byteDance._160_Intersection_of_Two_Linked_Lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    ListNode headA = ListNodes.getListOfNodes(1, 2, 3, 4, 5);
    ListNode headB = ListNodes.getListOfNodes(-1, -2, -3);
    headB.next.next.next = headA.next.next;
    assertEquals(headA.next.next, solution.getIntersectionNode(headA, headB));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
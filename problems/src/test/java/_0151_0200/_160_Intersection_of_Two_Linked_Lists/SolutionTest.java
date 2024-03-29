package _0151_0200._160_Intersection_of_Two_Linked_Lists;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    ListNode headA = ListNodes.getListOfNodes(1, 2, 3, 4, 5);
    ListNode headB = ListNodes.getListOfNodes(-1, -2, -3);
    headB.next.next.next = headA.next.next;
    assertEquals(headA.next.next, solution.getIntersectionNode(headA, headB));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
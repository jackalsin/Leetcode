package oracle._138_Copy_List_with_Random_Pointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertEquals(null, solution.copyRandomList(null));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Element(Solution solution) {
    Node head = new Node(1, null, null);
    solution.copyRandomList(head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1ElementWithRandom(Solution solution) {
    Node head = new Node(1, null, null);
    head.random = head;
    solution.copyRandomList(head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Element(Solution solution) {
    final Node head = new Node(1, null, null);
    head.next = new Node(2, null, null);
    head.random = head.next;
    head.next.random = head.next;
    solution.copyRandomList(head);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new O1SpaceSolution(),
        new ONSpaceSolution()
    );
  }
}
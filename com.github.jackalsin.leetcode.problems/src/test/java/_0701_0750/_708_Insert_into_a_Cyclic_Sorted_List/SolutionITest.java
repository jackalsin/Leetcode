package _0701_0750._708_Insert_into_a_Cyclic_Sorted_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition._708_Insert_into_a_Sorted_Circular_Linked_List.Node;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final Node head = new Node(1), expected = new Node(1);
    head.next = head;
    expected.next = new Node(0);
    expected.next.next = expected;
    final Node actual = solution.insert(head, 0);
    assertEquals(expected.val, actual.val);
    assertEquals(expected.next.val, actual.next.val);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
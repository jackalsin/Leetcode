package linkedin._138_Copy_List_with_Random_Pointer;

import definition._138_Copy_List_with_Random_Pointer.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertNull(solution.copyRandomList(null));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Element(Solution solution) {
    Node head = new Node(1);
    solution.copyRandomList(head);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1ElementWithRandom(Solution solution) {
    Node head = new Node(1);
    head.random = head;
    solution.copyRandomList(head);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new MapSolution(),
        new O1Solution()
    );
  }

}
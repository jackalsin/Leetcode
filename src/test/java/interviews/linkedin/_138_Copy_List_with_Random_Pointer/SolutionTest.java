package interviews.linkedin._138_Copy_List_with_Random_Pointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    assertNull(solution.copyRandomList(null));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1Element(Solution solution) {
    Node head = new Node(1);
    solution.copyRandomList(head);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1ElementWithRandom(Solution solution) {
    Node head = new Node(1);
    head.random = head;
    solution.copyRandomList(head);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

}
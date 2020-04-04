package _0401_0450._430_Flatten_a_Multilevel_Doubly_Linked_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._430_Flatten_a_Multilevel_Doubly_Linked_List.Node;
import utils._430_Flatten_a_Multilevel_Doubly_Linked_List.Nodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final Node input = Nodes.getNodes(1, 2, 3, 4, 5, 6),
        level2 = Nodes.getNodes(7, 8, 9, 10),
        level3 = Nodes.getNodes(11, 12);
    input.next.next.child = level2;
    input.next.next.child.next.child = level3;
    final Node expected = Nodes.getNodes(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6),
        acutal = solution.flatten(input);
    assertEquals(expected, acutal);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
package tableau._133_Clone_Graph;

import definition._133_Clone_Graph.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
class SolutionTest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Solution solution) {
    assertNull(solution.cloneGraph(null));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    Node node0 = new Node(0, new ArrayList<>());
    Node node1 = new Node(1, new ArrayList<>());
    Node node2 = new Node(2, new ArrayList<>());
    node0.neighbors.add(node1);
    node0.neighbors.add(node2);
    node1.neighbors.add(node0);
    node1.neighbors.add(node2);
    node2.neighbors.add(node0);
    node2.neighbors.add(node1);
    node2.neighbors.add(node2);

    assertEquals(node0, solution.cloneGraph(node0));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSolution()
    );
  }
}
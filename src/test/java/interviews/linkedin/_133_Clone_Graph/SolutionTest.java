package interviews.linkedin._133_Clone_Graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    assertNull(solution.cloneGraph(null));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
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

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
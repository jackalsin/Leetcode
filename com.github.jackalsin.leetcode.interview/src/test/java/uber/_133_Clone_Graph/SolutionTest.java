package uber._133_Clone_Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._133_Clone_Graph.Node;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new SlowSolution();
//    solution = new BfsSolution();
    solution = new DfsSolution();
  }

  @Test
  void testEmpty() {
    assertNull(solution.cloneGraph(null));
  }

  @Test
  void testOnlineCase() {
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
}
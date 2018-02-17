package interviews.uber._133_Clone_Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.UndirectedGraphNode;

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
    UndirectedGraphNode node0 = new UndirectedGraphNode(0);
    UndirectedGraphNode node1 = new UndirectedGraphNode(1);
    UndirectedGraphNode node2 = new UndirectedGraphNode(2);
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
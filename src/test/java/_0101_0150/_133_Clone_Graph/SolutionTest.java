package _0101_0150._133_Clone_Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils._133_Clone_Graph.Node;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
//    solution = new SlowSolution();
    solution = new AwesomeSolution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertNull(solution.cloneGraph(null));
  }

  @Test
  public void testOnlineCase() throws Exception {
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

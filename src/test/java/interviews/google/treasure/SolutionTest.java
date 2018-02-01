package interviews.google.treasure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class SolutionTest {

  @Test
  public void testOnlineCase1() throws Exception {
    final Graph graph = new Graph();
    Room room1 = new Room(1, false);
    Room room2 = new Room(2, false);
    Room room3 = new Room(3, false);
    Room room4 = new Room(4, false);
    Room room5 = new Room(5, true);

    Edge edge12 = new Edge(room1, room2, false);
    Edge edge21 = new Edge(room2, room1, false);
    Edge edge13 = new Edge(room1, room3, false);
    Edge edge34 = new Edge(room3, room4, false);
    Edge edge32 = new Edge(room3, room2, true);
    Edge edge24 = new Edge(room2, room4, false);
    Edge edge25 = new Edge(room2, room5, false);

    room1.addKey(edge32);
    graph.addRooms(room1, room2, room3, room4, room5);
    graph.addEdges(edge12, edge21, edge13, edge34, edge32, edge25, edge24);

    final Solution solution = new Solution(graph);
    assertTrue(solution.canFind(room1));
    assertFalse(solution.canFind(room3));
    assertFalse(solution.canFind(room4));
  }
}

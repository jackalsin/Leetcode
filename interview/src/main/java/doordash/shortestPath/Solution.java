package doordash.shortestPath;

import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2021
 */
public interface Solution {
  /**
   * return all the edges in the shortest path. If there is multiple, you need to return all of them
   *
   * @param edges [id, p, q]
   * @param start start point
   * @param end   end point
   * @return
   */
  Set<Edge> shortestPathEdges(final List<Edge> edges, final int start, final int end);
}

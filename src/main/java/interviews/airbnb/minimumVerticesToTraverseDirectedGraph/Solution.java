package interviews.airbnb.minimumVerticesToTraverseDirectedGraph;

import java.util.List;

public interface Solution {
  /**
   * Return minimum vertices needs to be visited to traverse all.
   *
   * @param edges edges[from][to] == 1 means it's there is a path from <tt>from</tt> to <tt>to</tt>
   * @param n     total vertices number
   * @return
   */
  List<Integer> getMin(int[][] edges, int n);
}

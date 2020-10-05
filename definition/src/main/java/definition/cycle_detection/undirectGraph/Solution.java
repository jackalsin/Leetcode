package definition.cycle_detection.undirectGraph;

/**
 * @author jacka
 * @version 1.0 on 7/13/2019
 */
public interface Solution {
  /**
   * @param edges edges
   * @return true if there is a cycle
   */
  boolean hasCycle(final int n, final int[][] edges);
}

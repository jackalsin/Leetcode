package doordash.shortestPath;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public interface Solution {
  /**
   * <a href='https://www.1point3acres.com/bbs/thread-773336-1-1.html'>Description</>
   *
   * @param paths {from, to, weight}
   * @return
   */
  boolean[] isOnShortestPath(final int[][] paths, final int start, final int target);
}

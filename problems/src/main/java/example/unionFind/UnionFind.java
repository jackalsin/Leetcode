package example.unionFind;

/**
 * @author jacka
 * @version 1.0 on 10/11/2017.
 */
public interface UnionFind {

  void union(int p, int q);

  /**
   * Return true when node <tt>p</tt> and <tt>q</tt> are connected (or in the same component).
   */
  boolean connected(int p, int q);

  /**
   * Return the root of the node <tt>p</tt> (or component identifier p)
   */
  int find(int p);

  /**
   * Return the component number.
   */
  int count();
}

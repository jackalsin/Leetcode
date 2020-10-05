package example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/12/2017.
 */
public final class Graph {
  private final int v;
  private int e;
  private final List<List<Integer>> adjs;

  public Graph(final int v) {
    if (v < 0) throw new IllegalStateException("v = " + v + " must be non-negative.");
    this.v = v;
    e = 0;
    adjs = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      adjs.add(new ArrayList<>());
    }
  }

  public int getV() {
    return v;
  }

  public int getE() {
    return e;
  }

  public void addEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    this.e++;
    adjs.get(v).add(w);
    adjs.get(w).add(v);
  }

  public Iterable<Integer> adj(int v) {
    validateVertex(v);
    return new ArrayList<>(adjs.get(v));
  }

  // throw an IndexOutOfBoundsException unless 0 <= v < V
  private void validateVertex(int v) {
    if (v < 0 || v >= this.v)
      throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (v-1));
  }
}

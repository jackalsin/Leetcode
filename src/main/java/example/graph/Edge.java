package example.graph;

/**
 * @author jacka
 * @version 1.0 on 10/11/2017.
 */
public final class Edge implements Comparable<Edge> {
  private final int v, w;
  private final double weight;

  /**
   * @param v either end, no difference with <tt>w</tt>
   * @param w either end, no difference with <tt>w</tt>
   */
  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    if (v == vertex) {
      return w;
    }
    return v;
  }

  @Override
  public int compareTo(Edge o) {
    return Double.compare(weight, o.weight);
  }

  @Override
  public String toString() {
    return "Edge{" +
        "v=" + v +
        ", w=" + w +
        ", weight=" + weight +
        '}';
  }
}

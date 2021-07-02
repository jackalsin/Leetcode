package doordash.shortestPath;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 7/1/2021
 */
public final class Edge {
  private final int v, w;

  public Edge(final Edge e) {
    this.v = e.v;
    this.w = e.w;
  }

  private Edge(int v, int w) {
    if (v < 0) throw new IllegalArgumentException("v cannot be negative, but got " + v);
    if (w < 0) throw new IllegalArgumentException("w cannot be negative, but got " + w);
    if (v > w) {
      this.v = w;
      this.w = v;
    } else {
      this.v = v;
      this.w = w;
    }
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    if (vertex == this.v) {
      return this.w;
    } else if (vertex == this.w) {
      return this.v;
    } else {
      throw new IllegalArgumentException("Illegal endpoint");
    }
  }

  public static Edge of(final int v, final int w) {
    return new Edge(v, w);
  }

  @Override
  public String toString() {
    return "Edge{" +
        "v=" + v +
        ", w=" + w +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Edge)) return false;
    Edge edge = (Edge) o;
    return v == edge.v && w == edge.w;
  }

  @Override
  public int hashCode() {
    return Objects.hash(v, w);
  }
}

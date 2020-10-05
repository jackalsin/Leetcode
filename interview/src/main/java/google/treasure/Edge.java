package google.treasure;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public final class Edge {

  public final Room from, to;
  public final boolean needsKey;

  public Edge(Room from, Room to, boolean needsKey) {
    this.from = from;
    this.to = to;
    this.needsKey = needsKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Edge)) {
      return false;
    }
    Edge edge = (Edge) o;
    return needsKey == edge.needsKey &&
        Objects.equals(from, edge.from) &&
        Objects.equals(to, edge.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, needsKey);
  }
}

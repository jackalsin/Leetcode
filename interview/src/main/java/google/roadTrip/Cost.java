package google.roadTrip;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public final class Cost {
  public final int board, distance;

  public Cost(int board, int distance) {
    this.board = board;
    this.distance = distance;
  }

  public static Cost of(final int board, final int distance) {
    return new Cost(board, distance);
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Cost)) return false;
    final Cost other = (Cost) obj;
    return board == other.board && distance == other.distance;
  }

  @Override
  public int hashCode() {
    return Objects.hash(board, distance);
  }

  public static final Cost MAX_VALUE = Cost.of(Integer.MAX_VALUE, Integer.MAX_VALUE);

  @Override
  public String toString() {
    return "Cost{" +
        "board=" + board +
        ", distance=" + distance +
        '}';
  }
}

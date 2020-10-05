package definition._133_Clone_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Nodes are labeled uniquely.
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public final class Node {

  public int val;

  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }

    Node that = (Node) o;

    if (val != that.val) {
      return false;
    }
    if (neighbors == null && that.neighbors == null) {
      return true;
    } else if (neighbors == null || that.neighbors == null) {
      return false;
    }
    Set<Integer> neighborLabels = getLabelSet(neighbors);
    Set<Integer> thatNeighborLabels = getLabelSet(that.neighbors);

    return containAllLables(neighborLabels, that.neighbors) && containAllLables
        (thatNeighborLabels, neighbors);
  }

  private Set<Integer> getLabelSet(List<Node> list) {
    Set<Integer> result = new HashSet<>();
    for (Node child : list) {
      result.add(child.val);
    }
    return result;
  }

  private boolean containAllLables(Set<Integer> thatNeighbors, List<Node>
      neighbors) {
    for (Node child : neighbors) {
      if (!thatNeighbors.contains(child.val)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = val;
    int neighborHashCode = 0;
    if (neighbors != null) {
      for (Node child : neighbors) {
        neighborHashCode = 31 * neighborHashCode + child.val;
      }
    }
    result = 31 * result + neighborHashCode;
    return result;
  }
}

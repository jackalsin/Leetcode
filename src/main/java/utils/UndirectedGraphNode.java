package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Nodes are labeled uniquely.
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public final class UndirectedGraphNode {

  public int label;

  public List<UndirectedGraphNode> neighbors;

  public UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UndirectedGraphNode)) {
      return false;
    }

    UndirectedGraphNode that = (UndirectedGraphNode) o;

    if (label != that.label) {
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

  private Set<Integer> getLabelSet(List<UndirectedGraphNode> list) {
    Set<Integer> result = new HashSet<>();
    for(UndirectedGraphNode child: list) {
      result.add(child.label);
    }
    return result;
  }

  private boolean containAllLables(Set<Integer> thatNeighbors, List<UndirectedGraphNode>
      neighbors) {
    for (UndirectedGraphNode child : neighbors) {
      if (!thatNeighbors.contains(child.label)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = label;
    int neighborHashCode = 0;
    if (neighbors != null) {
      for (UndirectedGraphNode child : neighbors) {
        neighborHashCode = 31 * neighborHashCode + child.label;
      }
    }
    result = 31 * result + neighborHashCode;
    return result;
  }
}

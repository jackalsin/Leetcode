package doordash.findDifference;

import java.util.ArrayList;
import java.util.List;

public final class Node {
  public final String key;
  public final int val;
  public final List<Node> children;

  public Node(String key, int val, List<Node> children) {
    this(key, val);
    this.children.addAll(children);
  }

  public Node(final String key, final int val) {
    this.key = key;
    this.val = val;
    this.children = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Node{" +
        "key='" + key + '\'' +
        ", val=" + val +
        ", children=" + children +
        '}';
  }
}

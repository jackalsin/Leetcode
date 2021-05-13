package google.leafSum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
public final class Node {
  public Node parent;
  public final int val;

  public final List<Node> children = new ArrayList<>();

  public Iterator<Node> itr;

  public Node(int val) {
    this.val = val;
  }
}

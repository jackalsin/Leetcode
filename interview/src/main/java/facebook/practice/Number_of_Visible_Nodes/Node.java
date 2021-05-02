package facebook.practice.Number_of_Visible_Nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class Node {
  public final int val;
  public final List<Node> children;

  public Node() {
    val = 0;
    children = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    children = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _children) {
    val = _val;
    children = _children;
  }
}

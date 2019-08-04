package interviews.linkedin._133_Clone_Graph;

import utils.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionI implements Solution {

  public Node cloneGraph(Node node) {
    final Map<Node, Node> originToNew = new HashMap<>();
    cloneGraph(originToNew, node);
    return originToNew.get(node);
  }

  private static Node cloneGraph(final Map<Node, Node> originToNew,
                                 Node root) {
    if (root == null) {
      return null;
    }
    if (originToNew.containsKey(root)) {
      return originToNew.get(root);
    }
    final Node newRoot = new Node(root.val, new ArrayList<>());
    originToNew.put(root, newRoot);
    for (Node u : root.neighbors) {
      newRoot.neighbors.add(cloneGraph(originToNew, u));
    }
    return newRoot;
  }

}
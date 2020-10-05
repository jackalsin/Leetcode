package _0101_0150._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public class AwesomeSolution implements Solution {
  private Map<Integer, Node> labelToClones = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) return null;

    Node result = labelToClones.get(node.val);
    if (result == null) {
      result = new Node(node.val, new ArrayList<>());
      labelToClones.put(result.val, result);
      for (Node child : node.neighbors) {
        result.neighbors.add(cloneGraph(child));
      }
    }
    return result;

  }
}

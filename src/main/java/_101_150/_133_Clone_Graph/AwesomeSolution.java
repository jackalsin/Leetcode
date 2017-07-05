package _101_150._133_Clone_Graph;

import java.util.HashMap;
import java.util.Map;

import utils.UndirectedGraphNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public class AwesomeSolution implements Solution {
  private Map<Integer, UndirectedGraphNode> labelToClones = new HashMap<>();

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;

    UndirectedGraphNode result = labelToClones.get(node.label);
    if (result == null) {
      result = new UndirectedGraphNode(node.label);
      labelToClones.put(result.label, result);
      for (UndirectedGraphNode child : node.neighbors) {
        result.neighbors.add(cloneGraph(child));
      }
    }
    return result;

  }
}

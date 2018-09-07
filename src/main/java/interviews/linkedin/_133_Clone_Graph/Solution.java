package interviews.linkedin._133_Clone_Graph;

import utils.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public class Solution {

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    final Map<UndirectedGraphNode, UndirectedGraphNode> originToNew = new HashMap<>();
    cloneGraph(originToNew, node);
    return originToNew.get(node);
  }

  private static UndirectedGraphNode cloneGraph(final Map<UndirectedGraphNode, UndirectedGraphNode> originToNew,
                                                UndirectedGraphNode root) {
    if (root == null) {
      return null;
    }
    if (originToNew.containsKey(root)) {
      return originToNew.get(root);
    }
    final UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
    originToNew.put(root, newRoot);
    for (UndirectedGraphNode u : root.neighbors) {
      newRoot.neighbors.add(cloneGraph(originToNew, u));
    }
    return newRoot;
  }

}
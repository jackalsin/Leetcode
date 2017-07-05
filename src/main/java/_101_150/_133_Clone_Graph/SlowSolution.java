package _101_150._133_Clone_Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import utils.UndirectedGraphNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class SlowSolution implements Solution {

  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
    UndirectedGraphNode result = new UndirectedGraphNode(node.label);

    Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
    Map<Integer, UndirectedGraphNode> labelToClones = new HashMap<>();

    labelToClones.put(node.label, result);

    queue.add(node);
    while (!queue.isEmpty()) {
      UndirectedGraphNode origin = queue.poll();
       for (UndirectedGraphNode neighbor: origin.neighbors) {
        if (!labelToClones.containsKey(neighbor.label)) {
          UndirectedGraphNode neighborDup = new UndirectedGraphNode(neighbor.label);
          labelToClones.put(neighbor.label, neighborDup);
          queue.add(neighbor);
        }
        labelToClones.get(origin.label).neighbors.add(labelToClones.get(neighbor.label));
      }
    }
    return result;
  }
}

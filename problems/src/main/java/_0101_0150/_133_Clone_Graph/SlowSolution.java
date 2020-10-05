package _0101_0150._133_Clone_Graph;

import definition._133_Clone_Graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class SlowSolution implements Solution {

  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Node result = new Node(node.val, new ArrayList<>());

    Queue<Node> queue = new ArrayDeque<>();
    Map<Integer, Node> labelToClones = new HashMap<>();

    labelToClones.put(node.val, result);

    queue.add(node);
    while (!queue.isEmpty()) {
      Node origin = queue.poll();
      for (Node neighbor : origin.neighbors) {
        if (!labelToClones.containsKey(neighbor.val)) {
          Node neighborDup = new Node(neighbor.val, new ArrayList<>());
          labelToClones.put(neighbor.val, neighborDup);
          queue.add(neighbor);
        }
        labelToClones.get(origin.val).neighbors.add(labelToClones.get(neighbor.val));
      }
    }
    return result;
  }
}

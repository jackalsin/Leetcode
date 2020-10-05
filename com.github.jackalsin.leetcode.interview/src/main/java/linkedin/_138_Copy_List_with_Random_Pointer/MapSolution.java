package linkedin._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/26/2019
 */
public final class MapSolution implements Solution {
  private final Map<Node, Node> srcToCopy = new HashMap<>();

  public Node copyRandomList(Node src) {
    if (src == null) {
      return null;
    }
    if (srcToCopy.containsKey(src)) {
      return srcToCopy.get(src);
    }
    final Node copy = new Node();
    srcToCopy.put(src, copy);
    copy.val = src.val;
    copy.next = copyRandomList(src.next);
    copy.random = copyRandomList(src.random);
    return copy;
  }
}

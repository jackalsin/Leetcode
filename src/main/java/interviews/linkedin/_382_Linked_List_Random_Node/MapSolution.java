package interviews.linkedin._382_Linked_List_Random_Node;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 8/13/2019
 */
public final class MapSolution implements Solution {
  private final TreeMap<Integer, Integer> sumToValue = new TreeMap<>();
  private final int sum;
  private final Random rand = new Random();

  /**
   * @param head The linked list's head.
   *             Note that the head is guaranteed to be not null, so it contains at least one node.
   */
  public MapSolution(ListNode head) {
    ListNode cur = head;
    final Map<Integer, Integer> map = new HashMap<>();
    while (cur != null) {
      map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
      cur = cur.next;
    }
    int sum = 0;
    for (final Map.Entry<Integer, Integer> e : map.entrySet()) {
      sum += e.getValue();
      sumToValue.put(sum, e.getKey());
    }
    this.sum = sum;
  }

  public int getRandom() {
    final int i = rand.nextInt(sum);
    return sumToValue.higherEntry(i).getValue();
  }
}

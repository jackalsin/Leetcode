package interviews.uber.accessLimit100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=304001&extra=page%3D1%26filter%3Dsortid%26sortid
 * %3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * 题目是RateLimit，允许每个客户在每秒内访问100次，bool isAllowed(int clientID)
 *
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
public class RateLimit {
  private static final long BIAS = 1_000_000_000;
  private final Map<Integer, Queue<Long>> userToHistory = new HashMap<>();

  public boolean isAllowed(final int clientId) {
    final Queue<Long> pq = userToHistory.getOrDefault(clientId, new PriorityQueue<>());
    final long curTime = System.nanoTime();
    while (!pq.isEmpty() && pq.peek() + BIAS <= curTime) {
      pq.remove();
    }
    final boolean res = pq.size() < 100;
    userToHistory.put(clientId, pq);
    return res;
  }

}

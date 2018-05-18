package interviews.pinterest.systemlog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
  // TODO: http://www.1point3acres.com/bbs/thread-300818-1-1.html
  public String archiveLog(final String[] logs) {
    final Map<Long, List<String>> uidToBehaviors = new HashMap<>();

    for (final String log : logs) {
      final String[] logArray = log.split(" ");
      final long uid = Long.parseLong(logArray[0]);
      uidToBehaviors.putIfAbsent(uid, new ArrayList<>());
      uidToBehaviors.get(uid).add(logArray[2]);
    }

    //
    final Node dummyHead = new Node("");
    for (Map.Entry<Long, List<String>> userB : uidToBehaviors.entrySet()) {
      insert(dummyHead, userB.getValue(), 0);
    }

    // gather reuslt;
    final List<String> result = new ArrayList<>();
    for (Node next : dummyHead.next.values()) {
      result.addAll(next.toNiceString());
    }
    return result.stream().reduce((x, y) -> x + "\n" + y).get();
  }

  private void insert(Node root, List<String> value, int i) {
    if (i == value.size()) {
      root.count++;
      return;
    }

    final String bName = value.get(i);
    root.next.putIfAbsent(bName, new Node(bName));
    root.count++;
    insert(root.next.get(bName), value, i + 1);
  }

  private static final class Node {
    private final String b;
    private final Map<String, Node> next = new HashMap<>();
    private int count = 0;

    Node(final String b) {
      this.b = b;
    }

    private List<String> toNiceString() {
      final List<String> result = new ArrayList<>();
      result.add("|---" + b + " (" + count + ")");
      final List<Node> ordered = new ArrayList<>(next.values());
      Collections.sort(ordered, (x, y) -> x.b.compareTo(y.b));
      for (Node nextNode : ordered) {
        result.addAll(nextNode.toNiceString().stream()
            .map(x -> "|    " + x).collect(Collectors.toList()));
      }
      return result;
    }
  }
}

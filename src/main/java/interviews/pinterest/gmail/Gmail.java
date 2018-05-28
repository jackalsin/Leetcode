package interviews.pinterest.gmail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Gmail {

  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, String> keyToValue = new HashMap<>();
  private final Node head, tail;

  public Gmail() {
    head = new Node(0);
    tail = new Node(Integer.MAX_VALUE);
    head.next = tail;
    tail.prev = head;
  }

  //  http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=357454&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D8%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
  public void addMessage(final String msg, final int id) {
    // update value
    keyToValue.put(id, msg);

    final Node curNode = keyToNode.getOrDefault(id, new Node(id));
    if (keyToNode.containsKey(id)) {
      removeFromDoubleLinkedList(curNode);
    } else {
      keyToNode.put(id, curNode);
    }
    insertToHead(curNode);

  }

  private void removeFromDoubleLinkedList(Node curNode) {
    final Node prev = curNode.prev, next = curNode.next;
    prev.next = next;
    next.prev = prev;

  }

  private void insertToHead(final Node curNode) {
    final Node next = head.next;

    head.next = curNode;
    curNode.prev = head;

    curNode.next = next;
    next.prev = curNode;
  }


  public String getMessages(final int id) {
    return keyToValue.get(id);
  }

  public List<String> getAllConversations() {
    final List<String> result = new ArrayList<>();
    Node cur = head.next;
    while (cur != tail) {
      result.add(keyToValue.get(cur.id));
      cur = cur.next;
    }
    return result;
  }

  private static final class Node {
    private final int id;
    private Node prev, next;

    private Node(final int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "id = " + id;
    }
  }
}

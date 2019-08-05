package utils._138_Copy_List_with_Random_Pointer;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
public final class Node {
  public int val;
  public Node next, random;

  @Deprecated
  public Node(int val) {
    this.val = val;
  }

  public Node() {
  }

  public Node(int _val, Node _next, Node _random) {
    val = _val;
    next = _next;
    random = _random;
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", next=" + next +
        ", random=" + random.val +
        '}';
  }
}

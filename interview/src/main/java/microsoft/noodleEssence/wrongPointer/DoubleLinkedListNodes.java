package microsoft.noodleEssence.wrongPointer;

public final class DoubleLinkedListNodes {
  private DoubleLinkedListNodes() {
  }

  public static DoubleLinkedListNode get(final int... vals) {
    final DoubleLinkedListNode dummy = new DoubleLinkedListNode(1);
    DoubleLinkedListNode prev = dummy;

    for (int val : vals) {
      DoubleLinkedListNode cur = new DoubleLinkedListNode(val);
      cur.prev = prev;
      prev.next = cur;
      prev = cur;
    }
    return dummy.next;
  }
}

package interviews.microsoft.noodleEssence.wrongPointer;

public final class DoubleLinkedListNode {
  DoubleLinkedListNode prev, next;
  final int val;

  public DoubleLinkedListNode(DoubleLinkedListNode prev, DoubleLinkedListNode next, int val) {
    this.prev = prev;
    this.next = next;
    this.val = val;
  }

  public DoubleLinkedListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }


}

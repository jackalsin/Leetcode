package interviews.airbnb.queueWithFixedSizeArray;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
public final class LinkedListSolution implements MyQueue {
  private static final int SIZE = 10;
  private final LinkedList<Node> values = new LinkedList<>();

  public void push(int x) {
    if (values.isEmpty() || values.getLast().size() == SIZE) {
      values.add(new Node());
    }
    final Node lastNode = values.getLast();
    lastNode.push(x);
  }


  public int pop() {
    final Node firstNode = values.getFirst();
    final int result = firstNode.pop();
    if (firstNode.size() == 0) {
      values.removeFirst();
    }
    return result;
  }


  public int peek() {
    final Node firstNode = values.getFirst();
    return firstNode.values[firstNode.left];
  }


  public boolean empty() {
    return values.isEmpty();
  }

  private static final class Node {
    private final int[] values = new int[SIZE];
    private int left = 0, // inclusive start
        right = 0; // exclusive end

    private void push(int val) {
      assert right != SIZE;
      values[right++] = val;
    }

    private int pop() {
      assert left != SIZE;
      return values[left++];
    }

    private int size() {
      return right - left;
    }
  }
}

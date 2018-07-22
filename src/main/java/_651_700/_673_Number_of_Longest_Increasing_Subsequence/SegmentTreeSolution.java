package _651_700._673_Number_of_Longest_Increasing_Subsequence;

public final class SegmentTreeSolution implements Solution {

  public int findNumberOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int min = nums[0], max = nums[0];
    for (int i : nums) {
      min = Math.min(i, min);
      max = Math.max(i, max);
    }
    final Node root = new Node(min, max);

    for (int num : nums) {
      // find less than <code>num</code>
      final Value val = query(root, num - 1);
      insert(root, num, new Value(val.length + 1, val.count));
    }

    return root.val.count;
  }

  private static void insert(final Node root, final int num, final Value value) {
    System.out.println("Insert " + root.min + " " + root.max);

    if (root.max == root.min) {
      root.val = merge(root.val, value);
      return;
    }

    if (num <= root.getMid()) {
      insert(root.getLeft(), num, value);
    } else {
      insert(root.getRight(), num, value);
    }
    root.val = merge(root.getLeft().val, root.getRight().val);
  }

  private static Value query(Node root, int num) {
    assert root != null;
    System.out.println("query " + root.min + " " + root.max);
    if (root.max <= num) {
      return root.val;
    }

    if (root.min > num) {
      return new Value(0, 1);
    }

    return merge(query(root.getLeft(), num), query(root.getRight(), num));
  }

  private static Value merge(Value val1, Value val2) {
    if (val1.length == val2.length) {
      if (val1.length == 0) {
        return new Value(0, 1);
      } else {
        // if 2 vals are the same, we should combine them
        return new Value(val1.length, val1.count + val2.count);
      }
    }
    return val1.length > val2.length ? new Value(val1) : new Value(val2);
  }

  /**
   * node.val.length indicates the longest increasing sub-sequence length ending here
   */
  private static final class Node {

    private final int min, max;
    private Node left, right;
    private Value val = new Value(0, 1);

    public Node(int min, int max) {
      this.min = min;
      this.max = max;
    }

    private int getMid() {
      return (max - min) / 2 + min;
    }

    /**
     * One way to do lazy propagation
     *
     * @return
     */
    public Node getLeft() {
      if (left == null) {
        left = new Node(min, getMid());
      }
      return left;
    }

    public Node getRight() {
      if (right == null) {
        right = new Node(getMid() + 1, max);
      }
      return right;
    }
  }

  private static final class Value {
    private final int length;
    private final int count;

    public Value(int length, int count) {
      this.length = length;
      this.count = count;
    }

    public Value(Value val) {
      this.length = val.length;
      this.count = val.count;
    }

    @Override
    public String toString() {
      return "Value{" +
          "length=" + length +
          ", count=" + count +
          '}';
    }
  }
}

package _0651_0700._673_Number_of_Longest_Increasing_Subsequence;

public final class SegmentTreeSolutionRef implements Solution {
  public int findNumberOfLIS(int[] nums) {
    if (nums.length == 0) return 0;
    int min = nums[0], max = nums[0];
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    final Node root = new Node(min, max);
    for (int num : nums) {
      Value v = query(root, num - 1);
      insert(root, num, new Value(v.length + 1, v.count));
    }
    return root.val.count;

  }

  public void insert(Node node, int key, Value val) {
    if (node.range_left == node.range_right) {
      node.val = merge(val, node.val);
      return;
    } else if (key <= node.getRangeMid()) {
      insert(node.getLeft(), key, val);
    } else {
      insert(node.getRight(), key, val);
    }
    node.val = merge(node.getLeft().val, node.getRight().val);
  }


  /**
   * Find a Node whose value.length is strictly less than or equals to  key value
   * <p>
   * Notice: the key passed in is not <code>num - 1</code>
   *
   * @param node
   * @param key
   * @return
   */
  public Value query(Node node, int key) {
    if (node.range_right <= key) {
      return node.val;
    } else if (node.range_left > key) {
      return new Value(0, 1);
    } else {
      return merge(query(node.getLeft(), key), query(node.getRight(), key));
    }
  }

  public Value merge(Value v1, Value v2) {
    if (v1.length == v2.length) {
      if (v1.length == 0) return new Value(0, 1);
      return new Value(v1.length, v1.count + v2.count);
    }
    return v1.length > v2.length ? v1 : v2;
  }

  /**
   * The information from [range_left, range_right]
   */
  private static final class Node {
    int range_left, range_right;
    Node left, right;
    Value val;

    public Node(int start, int end) {
      range_left = start;
      range_right = end;
      left = null;
      right = null;
      val = new Value(0, 1);
    }

    public int getRangeMid() {
      return range_left + (range_right - range_left) / 2;
    }

    public Node getLeft() {
      if (left == null) left = new Node(range_left, getRangeMid());
      return left;
    }

    public Node getRight() {
      if (right == null) right = new Node(getRangeMid() + 1, range_right);
      return right;
    }
  }

  private static final class Value {
    private final int length; // LIS length
    private final int count; // LIS count

    Value(int len, int ct) {
      length = len;
      count = ct;
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

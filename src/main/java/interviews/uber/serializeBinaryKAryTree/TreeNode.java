package interviews.uber.serializeBinaryKAryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class TreeNode {
  private final char val;
  private final List<TreeNode> next = new ArrayList<>();

  TreeNode(final char chr) {
    this.val = chr;
  }

  TreeNode(final char chr, TreeNode... next) {
    this.val = chr;
    this.next.addAll(Arrays.asList(next));
  }

  public char getVal() {
    return val;
  }

  public List<TreeNode> getNext() {
    return new ArrayList<>(next);
  }

  public void addNext(TreeNode c) {
    next.add(c);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode treeNode = (TreeNode) o;
    return val == treeNode.val &&
        Objects.equals(next, treeNode.next);
  }

  @Override
  public int hashCode() {

    return Objects.hash(val, next);
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}

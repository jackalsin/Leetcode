package utils;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public final class TreeLinkNode {
  public TreeLinkNode left;
  public TreeLinkNode right;
  public TreeLinkNode next;
  public int val;
  public TreeLinkNode(int x) {
    val = x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeLinkNode)) {
      return false;
    }

    TreeLinkNode that = (TreeLinkNode) o;

    if (val != that.val) {
      return false;
    }
    if (left != null ? !left.equals(that.left) : that.left != null) {
      return false;
    }
    if (right != null ? !right.equals(that.right) : that.right != null) {
      return false;
    }
    return next != null ? next.equals(that.next) : that.next == null;
  }

  @Override
  public int hashCode() {
    int result = left != null ? left.hashCode() : 0;
    result = 31 * result + (right != null ? right.hashCode() : 0);
    result = 31 * result + (next != null ? next.hashCode() : 0);
    result = 31 * result + val;
    return result;
  }

  @Override
  public String toString() {
    return "TreeLinkNode{" +
               "val=" + val +
               ", left=" + left +
               ", right=" + right +
               ", next=" + next +
               '}';
  }
}

package definition._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

public class Node {
  public int val;
  public Node left;
  public Node right;
  public Node parent;

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        ", parent=" + (parent == null ? null : parent.val) +
        '}';
  }
}

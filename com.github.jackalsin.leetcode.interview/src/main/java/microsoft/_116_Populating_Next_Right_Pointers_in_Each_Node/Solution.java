package microsoft._116_Populating_Next_Right_Pointers_in_Each_Node;

import definition.TreeLinkNode;

public class Solution { // TODO:

  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode levelHead = root, curNode = root;
    while (levelHead.left != null) {
      curNode = levelHead;
      while (curNode != null) {
        curNode.left.next = curNode.right;
        if (curNode.next != null) {
          curNode.right.next = curNode.next.left;
        }
        curNode = curNode.next;
      }

      levelHead = levelHead.left;
    }
  }

}

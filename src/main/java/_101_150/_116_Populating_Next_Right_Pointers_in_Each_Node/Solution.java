package _101_150._116_Populating_Next_Right_Pointers_in_Each_Node;

import utils.TreeLinkNode;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode levelHead = root;
    while (levelHead != null) {
      TreeLinkNode curNode = levelHead;
      while (curNode != null) {
        if (curNode.left != null) {
          curNode.left.next = curNode.right;
        }
        if (curNode.right != null && curNode.next != null) {
          curNode.right.next = curNode.next.left;
        }
        curNode = curNode.next;
      }
      levelHead = levelHead.left;
    }
  }
}

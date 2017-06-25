package _101_150._116_Populating_Next_Right_Pointers_in_Each_Node;

import utils.TreeLinkNode;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode parent = root;
    if (root == null) return;
    TreeLinkNode curNode = root.left;
    TreeLinkNode curLevelHead = parent;
    while (true) {
      if (curNode != null && parent != null) {
        curNode.next = parent.right;
        curNode = curNode.next;
        parent = parent.next;
        if (parent != null) {
          curNode.next = parent.left;
          curNode = curNode.next;
        }
      } else if(curLevelHead != null){
        parent = curLevelHead.left;
        curLevelHead = parent;
        if (curLevelHead == null) {
          return;
        }
        curNode = curLevelHead.left;
      } else { //last level
        return;
      }
    }
  }
}

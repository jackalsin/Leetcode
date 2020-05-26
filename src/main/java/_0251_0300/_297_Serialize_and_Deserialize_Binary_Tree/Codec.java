package _0251_0300._297_Serialize_and_Deserialize_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Codec {
  private static final String INVALID = "null";
  private static final String SEPARATOR = ",";
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildTree(root, sb);
    return sb.toString();
  }

  private void buildTree(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(INVALID).append(SEPARATOR);
    } else {
      sb.append(root.val).append(SEPARATOR);
      buildTree(root.left, sb);
      buildTree(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] splitData = data.split(SEPARATOR);
    Deque<String> deque = new ArrayDeque<>(Arrays.asList(splitData));
    return parseTree(deque);
  }

  private TreeNode parseTree(Deque<String> deque) {
    String curNodeVal = deque.remove();
    if (curNodeVal.equals(INVALID)) {
      return null;
    } else {
      TreeNode curNode = new TreeNode(Integer.valueOf(curNodeVal));
      curNode.left = parseTree(deque);
      curNode.right = parseTree(deque);
      return curNode;
    }
  }

  public static void main(String[] args) {
    Queue<String> ll = new LinkedList<>();
    ll.add(null);
    ll.add(null);
    ll.add(null);
    System.out.println(ll);
  }
}

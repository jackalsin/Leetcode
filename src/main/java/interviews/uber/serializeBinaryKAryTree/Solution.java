package interviews.uber.serializeBinaryKAryTree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/serialize-deserialize-n-ary-tree/
 *
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  private static final char END = ')';

  public static String serialize(final TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.toString();
  }

  private static void serialize(final StringBuilder sb, final TreeNode root) {
    sb.append(root.getVal());
    for (TreeNode n : root.getNext()) {
      serialize(sb, n);
    }
    sb.append(END);
  }

  public static TreeNode deserialize(final String str) {
    final Queue<Character> queue = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      queue.add(str.charAt(i));
    }

    return deserialize(queue);
  }

  private static TreeNode deserialize(final Queue<Character> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    final char chr = queue.remove();
    if (chr == END) {
      return null;
    }
    final TreeNode root = new TreeNode(chr);
    TreeNode next;
    while ((next = deserialize(queue)) != null) {
      root.addNext(next);
    }
    return root;
  }


}

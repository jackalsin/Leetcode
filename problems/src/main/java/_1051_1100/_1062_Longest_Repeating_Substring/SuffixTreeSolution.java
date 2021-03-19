package _1051_1100._1062_Longest_Repeating_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/14/2021
 */
public final class SuffixTreeSolution implements Solution {
  @Override
  public int longestRepeatingSubstring(String s) {
    SuffixTree st = new SuffixTree(s);
    return st.deepestInternalNodes();
  }

  private static final class SuffixTree {
    private static final char UNIQUE = '$';
    private static final int INF = Integer.MAX_VALUE;
    private final char[] chars;
    private int globalEnd = -1; // maybe
    private final Node root = new Node(-1, -1);
    private Node activeNode = root, last;
    private int activeEdgeAsTextIndex = -1, // from active, which way we should go
        activeLength = 0, // from root, how far is this.
        remainder = 0; // how many suffix to insert

    private SuffixTree(final String s) {
      final int len = s.length();
      this.chars = new char[len + 1];
      for (int i = 0; i <= len; ++i) {
        extend(i == len ? UNIQUE : s.charAt(i));
      }
      setSuffixIndexByDfs(root, 0);
    }

    private void setSuffixIndexByDfs(final Node cur, final int i) {
      if (cur.suffixLink == null && cur.start != -1) {
        cur.index = globalEnd + 1 - i;
      } else {
        for (final var e : cur.next.entrySet()) {
          final Node next = e.getValue();
          setSuffixIndexByDfs(next, i + next.len());
        }
      }
    }

    private boolean tryWalkDown(final Node cur) {
      final int edgeLen = cur.len();
      if (activeLength >= edgeLen) {
        activeEdgeAsTextIndex += edgeLen;
        activeLength -= edgeLen;
        activeNode = cur;
        return true;
      }
      return false;
    }

    private void extend(final char c) {
      chars[++globalEnd] = c;
      ++remainder;
      last = null;
      while (remainder > 0) {
        if (activeLength == 0) activeEdgeAsTextIndex = globalEnd;
        if (activeNode.next.containsKey(chars[activeEdgeAsTextIndex])) {
          final Node next = activeNode.next.get(chars[activeEdgeAsTextIndex]);
          if (tryWalkDown(next)) continue;
          if (chars[next.start + activeLength] == c) { // if match, we do nothing.
            addSuffixLink(activeNode);
            ++activeLength;
            break;
          }
          Node internalSplitNode = new Node(next.start, next.start + activeLength - 1);

          activeNode.next.put(chars[activeEdgeAsTextIndex], internalSplitNode);
          internalSplitNode.next.put(c, new Node(globalEnd, INF));
          next.start += activeLength;
          internalSplitNode.next.put(chars[next.start], next);
          addSuffixLink(internalSplitNode);
        } else { // not path, needs to add one.
          activeNode.next.put(chars[activeEdgeAsTextIndex], new Node(globalEnd, INF));
          addSuffixLink(activeNode);
        }

        --remainder;
        if (activeNode != root) activeNode = activeNode.suffixLink;
        else if (activeLength > 0) {
          --activeLength;
          activeEdgeAsTextIndex = globalEnd - remainder + 1;
        }
      } // done of while
    }

    private void addSuffixLink(final Node cur) {
      if (last != null) {
        last.suffixLink = cur;
      }
      last = cur;
    }

    // deep
    private int maxDepth = 0;

    public int deepestInternalNodes() {
      maxDepth = 0;
      deepestInternalNodes(root, 0);
      return maxDepth;
    }

    private void deepestInternalNodes(final Node cur, final int dep) {
      if (cur == null) return;
      if (cur.index == -1) { // is an internal node
        maxDepth = Math.max(maxDepth, dep);
        for (final Node val : cur.next.values()) {
          deepestInternalNodes(val, dep + val.len());
        }
      }
    }

    private final class Node {
      private int start, end;
      private Node suffixLink;
      private final Map<Character, Node> next = new HashMap<>();
      private int index = -1;

      private Node(final int start, final int end) {
        this.start = start;
        this.end = end;
        if (end != INF) suffixLink = root;
      } // end of Node constructor

      private int len() {
        return Math.min(end, globalEnd) - start + 1;
      }

      @Override
      public String toString() {
        return "Node{" +
            "start=" + start +
            ", end=" + end +
//            ", suffixLink=" + suffixLink +
            ", next=" + next +
            ", index=" + index +
            '}';
      }
    }
  }
}

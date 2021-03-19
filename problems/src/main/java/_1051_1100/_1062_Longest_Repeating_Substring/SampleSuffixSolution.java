package _1051_1100._1062_Longest_Repeating_Substring;

/**
 * @author jacka
 * @version 1.0 on 3/17/2021
 */
public final class SampleSuffixSolution implements Solution {
  public int longestRepeatingSubstring(String S) {
    SuffixTree st = new SuffixTree(S);
    return st.deepInternalNode();
  }

  static class SuffixTree {

    public static final int MAX_CHAR = 128;

    class Node {
      int start, index = -1, end;
      Node suffixLink;
      Node[] chds = new Node[MAX_CHAR];

      public Node(int start, int end) {
        this.start = start;
        this.end = end;
        if (end != inf) suffixLink = root;
      }

      int len() {
        return Math.min(end, globalEnd) - start + 1;
      }

      @Override
      public String toString() {
        return "Node{" +
            "start=" + start +
            ", index=" + index +
            ", end=" + end +
//            ", suffixLink=" + suffixLink +
//            ", chds=" + Arrays.toString(chds) +
            '}';
      }
    }

    Node root = new Node(-1, -1);
    Node lastNewNode = null;
    int globalEnd = -1;
    int inf = Integer.MAX_VALUE / 2;
    char[] text;

    Node activeNode = root;
    int activeEdgeAsTextIndex = -1;
    int activeLength = 0;
    int remaining = 0;

    boolean tryWalkDown(Node cur) {
      int edgeLen = cur.len();
      if (activeLength >= edgeLen) {
        activeEdgeAsTextIndex += edgeLen;
        activeLength -= edgeLen;
        activeNode = cur;
        return true;
      }
      return false;
    }

    private void extend(char c) {
      text[++globalEnd] = c;
      remaining++;
      lastNewNode = null;
      while (remaining > 0) {
        if (activeLength == 0) activeEdgeAsTextIndex = globalEnd;
        if (activeNode.chds[text[activeEdgeAsTextIndex]] == null) {
          activeNode.chds[text[activeEdgeAsTextIndex]] = new Node(globalEnd, inf);
          addSuffixLinkIfLastNodeExists(activeNode);
        } else {
          Node chd = activeNode.chds[text[activeEdgeAsTextIndex]];
          if (tryWalkDown(chd)) continue;
          if (text[chd.start + activeLength] == c) { // do nothing
            addSuffixLinkIfLastNodeExists(activeNode);
            activeLength++;
            break;
          }
          Node internalSplit = new Node(chd.start, chd.start + activeLength - 1);

          activeNode.chds[text[activeEdgeAsTextIndex]] = internalSplit;
          internalSplit.chds[c] = new Node(globalEnd, inf);
          chd.start += activeLength;
          internalSplit.chds[text[chd.start]] = chd;
          addSuffixLinkIfLastNodeExists(internalSplit);
        }
        remaining--;
        if (activeNode != root) activeNode = activeNode.suffixLink;
        else if (activeLength > 0) {
          activeLength--;
          activeEdgeAsTextIndex = globalEnd - remaining + 1;
        }
      }
    }

    private void addSuffixLinkIfLastNodeExists(Node node) {
      if (lastNewNode != null)
        lastNewNode.suffixLink = node;
      lastNewNode = node;
    }

    private void setSuffixIndexByDFS(Node cur, int labelHeight) {
      if (cur.suffixLink == null && cur.start != -1) {
        cur.index = globalEnd + 1 - labelHeight;
      } else {
        for (int i = 0; i < MAX_CHAR; i++) {
          if (cur.chds[i] == null) continue;
          setSuffixIndexByDFS(cur.chds[i], labelHeight + cur.chds[i].len());
        }
      }
    }

    public SuffixTree(String str) {
      this.text = new char[str.length() + 1];
      for (int i = 0; i <= str.length(); i++) {
        char c = (i == str.length() ? '$' : str.charAt(i));
        extend(c);
      }
      setSuffixIndexByDFS(root, 0);
    }

    int maxDepth;

    public int deepInternalNode() {
      maxDepth = 0;
      help(root, 0);
      return maxDepth;
    }

    void help(Node cur, int dep) {
      if (cur == null) return;
      if (cur.index == -1) { // internal
        maxDepth = Math.max(maxDepth, dep);
        for (int i = 0; i < MAX_CHAR; i++) {
          if (cur.chds[i] == null) continue;
          help(cur.chds[i], dep + cur.chds[i].len());
        }
      }
    }
  }
}

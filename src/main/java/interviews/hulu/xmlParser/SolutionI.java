package interviews.hulu.xmlParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public XmlNode parse(String[] tokens) {
    if (tokens == null) {
      throw new NullPointerException();
    }
    if (tokens.length == 0) {
      throw new IllegalArgumentException("Array toke cannot be empty");
    }
    return traverse(new ArrayDeque<>(Arrays.asList(tokens)));
  }

  private static XmlNode traverse(final Queue<String> tokens) {
    final String startToken = tokens.remove();
    final int len = startToken.length();
    assert startToken.charAt(0) == '<' && startToken.charAt(len - 1) == '>';
    assert !tokens.isEmpty();
    final boolean isValueNode = isValueNode(tokens.peek());
    final String label = startToken.substring(1, len - 1),
        expectedEndToken = getEndToken(label);
    XmlNode root = null;
    while (!tokens.isEmpty() && !tokens.peek().equals(expectedEndToken)) {
      if (isValueNode) {
        root = new XmlNode(label, tokens.remove());
      } else {
        if (root == null) {
          root = new XmlNode(label, new ArrayList<>());
        }
        root.addChild(traverse(tokens));
      }
    }
    final boolean isEndCorrect = !tokens.isEmpty() && tokens.remove().equals(expectedEndToken);
    assert isEndCorrect;
    return root;
  }

  private static boolean isValueNode(final String firstToken) {
    final int len = firstToken.length();
    return !(firstToken.charAt(0) == '<' && firstToken.charAt(len - 1) == '>');
  }

  private static String getEndToken(final String label) {
    return new StringBuilder("</").append(label).append(">").toString();
  }
}

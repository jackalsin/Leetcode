package uber.codeSignal.matrixPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 4/16/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> print(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final LinkedList<StringBuilder> beforePadding = new LinkedList<>();
    for (int row = 0; row < rows; ++row) {
      beforePadding.addFirst(new StringBuilder());
      for (int col = 0; col <= row; col++) {
        beforePadding.get(col).append(matrix[row][col]);
      }
    }
    final List<StringBuilder> topRight = new ArrayList<>();
    for (int i = 1; i < cols; ++i) topRight.add(new StringBuilder());
    for (int row = 0; row < rows; row++) {
      for (int col = row + 1; col < cols; ++col) {
        topRight.get(col - 1).append(matrix[row][col]);
      }
    }
    beforePadding.addAll(topRight);
//    System.out.println(beforePadding);
    final List<Node> sorted = new ArrayList<>();
    for (int i = 0; i < beforePadding.size(); ++i) {
      final StringBuilder cur = beforePadding.get(i);
      final char chr = cur.charAt(cur.length() - 1);
      while (cur.length() < rows) {
        cur.append(chr);
      }
      sorted.add(new Node(cur.toString(), i));
    }
    sorted.sort(Comparator.comparing(a -> a.word));
//    System.out.println(sorted);
    return sorted.stream().map(e -> e.index).collect(Collectors.toList());
  }

  private static final class Node {
    private final String word;
    private final int index;

    private Node(String word, int index) {
      this.word = word;
      this.index = index;
    }

    @Override
    public String toString() {
      return "Node{" +
          "word='" + word + '\'' +
          ", index=" + index +
          '}';
    }
  }
}

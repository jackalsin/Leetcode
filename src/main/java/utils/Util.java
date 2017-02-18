package utils;

import java.util.Arrays;

/**
 * A utility class to provide several tools to create or control structure of notes.
 *
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public final class Util {

  /**
   * Avoid initialization.
   */
  private Util() {
  }

  /**
   * Return the head of a list of {@code ListNode}.
   *
   * @param values an array of integer values to be assigned to the list.
   * @return the head of the integer list of ListNode
   * @throws NullPointerException     if values is null
   * @throws IllegalArgumentException if values is empty.
   */
  public static ListNode getListOfNodes(int[] values) {
    if (values == null) {
      throw new NullPointerException();
    } else if (values.length == 0) {
      throw new IllegalArgumentException("the array length cannot be zero.");
    } else {
      ListNode dummy = new ListNode(Integer.MIN_VALUE);
      ListNode cur = dummy;
      for (int val : values) {
        cur.next = new ListNode(val);
        cur = cur.next;
      }
      return dummy.next;
    }
  }

  public static boolean TwoDimensionArrayEquals(char[][] board1, char[][] board2) {
    if (board1 == null) {
      throw new NullPointerException("board1 cannot be null");
    }
    if (board2 == null) {
      throw new NullPointerException("board2 cannot be null");
    }
    if (board1.length == 0 && board2.length == 0) {
      return true;
    }
    if (board1.length != board2.length) {
      return false;
    }
    int rows = board1.length;
    for (int row = 0; row < rows; row++) {
      if (board1[row].length == 0 && board2[row].length == 0) {
        return true;
      }
      if (board1[row].length != board2[row].length) {
        return false;
      }
      int cols = board1[row].length;
      for (int col = 0; col < cols; col++) {
        if (board1[row][col] != board2[row][col]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void display2DimensionArray(char[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (char[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }
}

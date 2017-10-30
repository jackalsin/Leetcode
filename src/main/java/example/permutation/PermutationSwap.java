package example.permutation;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public final class PermutationSwap {
  public void permutation(String s) {
    permutation(s.toCharArray(), 0);
  }

  private void permutation(final char[] chars, int startIndex) {
    if (startIndex == chars.length - 1) {
      System.out.println(Arrays.toString(chars));
    } else {
      for (int i = startIndex; i < chars.length; i++) {
        swap(chars, startIndex, i);
        permutation(chars, startIndex + 1);
        swap(chars, startIndex, i);
      }
    }
  }

  private static void swap(char[] chars, int i, int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

  public static void main(String[] args) {
    new PermutationSwap().permutation("abc");
  }
}

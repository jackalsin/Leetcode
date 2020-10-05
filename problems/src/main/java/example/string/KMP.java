package example.string;

public interface KMP {

  public int substring(final String s, final String p);

  /**
   * Generate the next[] array;
   *
   * @param pattern
   * @return
   */
  int[] getNext(final String pattern);
}

package assertions._443_String_Compression;

/**
 * @author jacka
 * @version 1.0 on 2/23/2021
 */
public final class Assertions {
  private Assertions() {
  }

  /**
   * @param expected
   * @param actual
   * @param range
   */
  public static void assertArrayEquals(final char[] expected, final char[] actual, final int
      range) {
    assert expected.length == range;
    for (int i = 0; i < range; i++) {
      assert expected[i] == actual[i];
    }
  }
}

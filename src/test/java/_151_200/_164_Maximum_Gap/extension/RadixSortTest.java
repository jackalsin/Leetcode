package _151_200._164_Maximum_Gap.extension;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/25/2017.
 */
public class RadixSortTest {
  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void test1() throws Exception {
    final int[] input = new int[] {1};
    final int[] expect = new int[] {1};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }

  @Test
  public void test2() throws Exception {
    final int[] input = new int[] {2, 1};
    final int[] expect = new int[] {1, 2};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }

  @Test
  public void test11() throws Exception {
    final int[] input = new int[] {4, 233, 21, 40, 42, 32, 1};
    final int[] expect = new int[] {1, 4, 21, 32, 40, 42, 233};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }
}

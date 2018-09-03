package example.sort.radixSort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/3/18
 */
class RadixSortTest {

  @BeforeEach
  void setUp() {

  }

  @Test
  void test1() {
    final int[] input = new int[]{1};
    final int[] expect = new int[]{1};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }

  @Test
  void test2() {
    final int[] input = new int[]{2, 1};
    final int[] expect = new int[]{1, 2};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }

  @Test
  void test11() {
    final int[] input = new int[]{4, 233, 21, 40, 42, 32, 1};
    final int[] expect = new int[]{1, 4, 21, 32, 40, 42, 233};
    RadixSort.sort(input);
    assertArrayEquals(expect, input);
  }

}
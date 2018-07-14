package interviews.microsoft._075_Sort_Colors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void test1() {
    final int[] input = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    final int[] expected = new int[]{1, 2, 2, 1, 0, 2, 1, 2};
    Arrays.sort(expected);
    solution.sortColors(input);
    System.out.println(Arrays.toString(input));
    assertArrayEquals(expected, input);
  }

}
package _0651_0700._667_Beautiful_Arrangement_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int n = 3, k = 1;
    final int[] actual = solution.constructArray(n, k);
    assertTrue(isInRange(actual, n), "Array not in range " + Arrays.toString(actual));
    assertEquals(k, count(actual));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int n = 3, k = 2;
    final int[] actual = solution.constructArray(n, k);
    assertTrue(isInRange(actual, n), "Array not in range " + Arrays.toString(actual));
    assertEquals(k, count(actual));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int n = 9, k = 7;
    final int[] actual = solution.constructArray(n, k);
    assertTrue(isInRange(actual, n), "Array not in range " + Arrays.toString(actual));
    assertEquals(k, count(actual));
  }

  @Test
  public void testCase4And2() {
    final int n = 4, k = 2;
    final int[] actual = solution.constructArray(n, k);
    assertTrue(isInRange(actual, n), "Array not in range " + Arrays.toString(actual));
    assertEquals(k, count(actual));
  }

  private static boolean isInRange(final int[] array, final int max) {
    return Arrays.stream(array).noneMatch(i -> (i < 0) || (i > max));
  }

  private static int count(int[] array) {
    final Set<Integer> set = new HashSet<>();
    for (int i = 1; i < array.length; i++) {
      set.add(Math.abs(array[i] - array[i - 1]));
    }
    return set.size();
  }
}

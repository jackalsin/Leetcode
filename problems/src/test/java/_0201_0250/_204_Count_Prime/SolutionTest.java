package _0201_0250._204_Count_Prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void countPrimes() throws Exception {
    assertEquals(0, solution.countPrimes(1));
    assertEquals(0, solution.countPrimes(2));
    assertEquals(1, solution.countPrimes(3));
    assertEquals(2, solution.countPrimes(4));
    assertEquals(2, solution.countPrimes(5));
    assertEquals(3, solution.countPrimes(6));
  }

  @Test
  public void isPrime() throws Exception {
    assertFalse(Solution.isPrime(1));
    assertTrue(Solution.isPrime(2));
    assertTrue(Solution.isPrime(3));
    assertFalse(Solution.isPrime(4));
    assertTrue(Solution.isPrime(5));
    assertFalse(Solution.isPrime(6));
    assertTrue(Solution.isPrime(7));
    assertFalse(Solution.isPrime(8));
    assertFalse(Solution.isPrime(9));
    assertFalse(Solution.isPrime(10));
    assertTrue(Solution.isPrime(11));
    assertFalse(Solution.isPrime(12));
  }
}

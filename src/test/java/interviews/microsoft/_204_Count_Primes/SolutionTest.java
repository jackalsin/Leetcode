package interviews.microsoft._204_Count_Primes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void countPrimes() throws Exception {
    assertEquals(0, solution.countPrimes(1));
    assertEquals(0, solution.countPrimes(2));
    assertEquals(1, solution.countPrimes(3));
    assertEquals(2, solution.countPrimes(4));
    assertEquals(2, solution.countPrimes(5));
    assertEquals(3, solution.countPrimes(6));
  }


}
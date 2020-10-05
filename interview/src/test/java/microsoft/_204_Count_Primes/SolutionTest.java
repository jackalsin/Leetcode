package microsoft._204_Count_Primes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DpSolution();
  }

  @Test
  void countPrimes() {
    assertEquals(0, solution.countPrimes(1));
    assertEquals(0, solution.countPrimes(2));
    assertEquals(1, solution.countPrimes(3));
    assertEquals(2, solution.countPrimes(4));
    assertEquals(2, solution.countPrimes(5));
    assertEquals(3, solution.countPrimes(6));
    assertEquals(4, solution.countPrimes(10));
  }

}
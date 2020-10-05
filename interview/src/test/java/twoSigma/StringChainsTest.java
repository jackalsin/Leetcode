package twoSigma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringChainsTest {
  private StringChains solution;

  @BeforeEach
  void setUp() {
    solution = new StringChains();
  }

  @Test
  void testOnlineCase1() {
    final List<String> input = Arrays.asList(
        "a", "an", "and", "bear"
    );
    assertEquals(3, solution.get(input));
  }
}
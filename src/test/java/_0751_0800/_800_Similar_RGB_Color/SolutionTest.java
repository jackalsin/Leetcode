package _0751_0800._800_Similar_RGB_Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String color = "#09f166", output = "#11ee66";
    assertEquals(output, solution.similarRGB(color));
  }

  @Test
  void testOnlineCase2() {
    final String color = "#1c9e03", output = "#229900";
    assertEquals(output, solution.similarRGB(color));
  }

  @Test
  void testOnlineCase3() {
    final String color = "#0064ba", output = "#0066bb";
    assertEquals(output, solution.similarRGB(color));
  }
}
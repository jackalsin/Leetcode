package apple.O1List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
class O1ListImplTest {
  private O1List<Integer> solution;

  @BeforeEach
  void setUp() {
    solution = new O1ListImpl<>();
  }

  @Test
  void testOnlineCaseAddContains() {
    solution.addLast(1);
    assertTrue(solution.contains(1));
    solution.addLast(2);
    assertTrue(solution.contains(2));
    solution.addLast(1);
    assertTrue(solution.contains(1));
  }

  @Test
  void testOnlineCaseRemove() {
    solution.addLast(1);
    solution.addLast(2);
    solution.addLast(1);
    solution.addLast(2);
    final List<Integer> current1 = solution.toList();
    final List<Integer> expected1 = List.of(1, 2, 1, 2);
    assertEquals(expected1, current1);
    solution.delete(2);
    final List<Integer> current2 = solution.toList(),
        expected2 = List.of(1, 1, 2);
    assertEquals(expected2, current2);
    solution.delete(1);
    final List<Integer> current3 = solution.toList(),
        expected3 = List.of(1, 2);
    assertEquals(expected3, current3);
  }
}
package interviews.uber._432_All_O_one_Data_Structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllOneTest {
  @BeforeEach
  void setUp() {
  }

  @Test
  void testOnlineCase1() {
    final AllOne allOne = new AllOne();
    assertEquals("", allOne.getMaxKey());
    assertEquals("", allOne.getMinKey());

    allOne.inc("1");
    assertEquals("1", allOne.getMaxKey());
    assertEquals("1", allOne.getMinKey());

    allOne.inc("2");
    allOne.inc("2");
    assertEquals("2", allOne.getMaxKey());
    assertEquals("1", allOne.getMinKey());

    allOne.inc("2");
    assertEquals("2", allOne.getMaxKey());
    assertEquals("1", allOne.getMinKey());

    allOne.dec("1");
    assertEquals("2", allOne.getMaxKey());
    assertEquals("2", allOne.getMinKey());

    allOne.inc("1");
    assertEquals("2", allOne.getMaxKey());
    assertEquals("1", allOne.getMinKey());

  }

  @Test
  void testOnlineCase2() {
//    ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
//    [[],      ["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
    final AllOne allOne = new AllOne();
    assertEquals("", allOne.getMaxKey());
    assertEquals("", allOne.getMinKey());

    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");
    allOne.inc("b");
    allOne.dec("b");
    allOne.dec("b");
    assertEquals("b", allOne.getMaxKey());
    assertEquals("a", allOne.getMinKey());

  }

  @Test
  void testFailedCase1() {
//    ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
//    [[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
    final AllOne allOne = new AllOne();

    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("c");
    allOne.inc("d");
    allOne.inc("a");
    allOne.inc("b");
    allOne.inc("c");
    allOne.inc("d");
    allOne.inc("c");
    allOne.inc("d");
    allOne.inc("d");
    allOne.inc("a");
    assertEquals("b", allOne.getMinKey());

  }
}
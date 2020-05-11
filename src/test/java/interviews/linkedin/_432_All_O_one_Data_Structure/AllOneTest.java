package interviews.linkedin._432_All_O_one_Data_Structure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
class AllOneTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(AllOne allOne) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(AllOne allOne) {
//    ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
//    [[],      ["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(AllOne allOne) {
//    ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
//    [[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]

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

  private static final String HELLO = "hello", WORLD = "world", LEET = "leet";

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(AllOne allOne) {
//    ["AllOne","inc",  "inc",    "inc",    "dec",    "inc",    "inc","getMaxKey","dec","dec","dec","getMaxKey"]
//    [[],    ["hello"],["world"],["hello"],["world"],["hello"],["leet"],[],["hello"],["hello"],["hello"],[]]
    allOne.inc(HELLO);
    allOne.inc(WORLD);
    allOne.inc(HELLO);
    allOne.dec(WORLD);
    allOne.inc(HELLO);
    allOne.inc(LEET);

    assertEquals(HELLO, allOne.getMaxKey());

    allOne.dec(HELLO);
    allOne.dec(HELLO);
    allOne.dec(HELLO);

    assertEquals(LEET, allOne.getMaxKey());
  }

  static Stream<AllOne> solutionStream() {
    return Stream.of(
        new AllOneI(),
        new AllOneII(),
        new AllOneIII(),
        new AllOneIV()
    );
  }
}
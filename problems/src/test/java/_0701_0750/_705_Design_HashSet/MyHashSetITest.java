package _0701_0750._705_Design_HashSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
class MyHashSetITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MyHashSet hashSet) {
    hashSet.add(1);
    hashSet.add(2);
    assertTrue(hashSet.contains(1));    // returns true
    assertFalse(hashSet.contains(3));    // returns false (not found)
    hashSet.add(2);
    assertTrue(hashSet.contains(2));    // returns true
    hashSet.remove(2);
    assertFalse(hashSet.contains(2));    // returns false (already removed)
  }

  static Stream<MyHashSet> solutionStream() {
    return Stream.of(
        new MyHashSetI()
    );
  }
}
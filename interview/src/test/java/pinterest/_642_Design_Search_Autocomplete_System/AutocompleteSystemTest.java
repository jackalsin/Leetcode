package pinterest._642_Design_Search_Autocomplete_System;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutocompleteSystemTest {

  @Test
  void testOnlineCase1() {
    final String[] input = {"i love you", "island", "ironman", "i love leetcode"};
    final int[] times = {5, 3, 2, 2};
    final AutocompleteSystem autocompleteSystem = new AutocompleteSystem(input, times);
    final Set<String> expectedI = Set.of("i love you", "island", "i love leetcode");
    assertEquals(expectedI, new HashSet<>(autocompleteSystem.input('i')));
    final Set<String> expectedSpace = Set.of("i love you", "i love leetcode");
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input(' ')));
    final Set<String> expectedA = Set.of();
    assertEquals(expectedA, new HashSet<>(autocompleteSystem.input('a')));
    final Set<String> expectedPound = Set.of();
    assertEquals(expectedPound, new HashSet<>(autocompleteSystem.input('#')));
  }

  @Test
  void testFailedCase() {
    final String[] input = {"abc", "abbc", "a"};
    final int[] times = {3, 3, 3};
    final AutocompleteSystem autocompleteSystem = new AutocompleteSystem(input, times);
    final Set<String> expectedB = Set.of();
    assertEquals(expectedB, new HashSet<>(autocompleteSystem.input('b')));
    final Set<String> expectedC = Set.of();
    assertEquals(expectedC, new HashSet<>(autocompleteSystem.input('c')));
    final Set<String> expectedSpace = Set.of();
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input('#')));

    final Set<String> expectedBAgain = Set.of("bc");
    assertEquals(expectedBAgain, new HashSet<>(autocompleteSystem.input('b')));
    assertEquals(expectedBAgain, new HashSet<>(autocompleteSystem.input('c')));
    assertEquals(expectedSpace, new HashSet<>(autocompleteSystem.input('#')));


    final List<String> afterA = List.of("a", "abbc", "abc");
    assertEquals(afterA, autocompleteSystem.input('a'));
    final List<String> afterB = List.of("abbc", "abc");
    assertEquals(afterB, autocompleteSystem.input('b'));
  }

}
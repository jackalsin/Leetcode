package pinterest._609_Find_Duplicate_File_in_System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[] input =
        {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
    final Set<Set<String>> expected = Set.of(Set.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), Set.of
        ("root/a/1.txt", "root/c/3.txt"));

    final List<List<String>> actual = solution.findDuplicate(input);

    Set<Set<String>> actualSet = actual.stream().map(HashSet::new).collect(Collectors.toSet());
    assertEquals(expected, actualSet);
  }

  @Test
  void testFailed1() {
    final String[] input =
        {"root/a 1.txt(abcd) 2.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"};
    final Set<Set<String>> expected = Set.of();

    final List<List<String>> actual = solution.findDuplicate(input);

    Set<Set<String>> actualSet = actual.stream().map(HashSet::new).collect(Collectors.toSet());
    assertEquals(expected, actualSet);
  }
}
package interviews.airbnb.fileSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
//  ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//  [[],          ["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
//[null,[],null,null,["a"],"hello"]
    assertNull(solution.get_value("/"));
    solution.create("/a", "a");
    assertEquals("a", solution.get_value("/a"));
    solution.create("/a/b", "ab");
    assertEquals("ab", solution.get_value("/a/b"));
    solution.create("/a/b/c", "abc");
    assertEquals("abc", solution.get_value("/a/b/c"));
    assertTrue(solution.set_value("/a/b/c", "hello"));
    assertEquals("hello", solution.get_value("/a/b/c"));
    assertFalse(solution.set_value("/av", "c"));
  }

  @Test
  void testOnlineCase2() {
    solution.watch("/", () -> System.out.println("/"));

    System.out.println("*******************");
    System.out.println("Stdout: /");
    solution.create("/a", "a");
    assertEquals("a", solution.get_value("/a"));
    solution.watch("/a", () -> System.out.println("/a"));

    System.out.println("*******************");
    System.out.println("Stdout: /, /a");
    solution.create("/a/b", "ab");
    assertEquals("ab", solution.get_value("/a/b"));
    solution.watch("/a/b", () -> System.out.println("/a/b"));

    System.out.println("*******************");
    System.out.println("Stdout: /, /a, /a/b");
    solution.create("/a/b/c", "abc");
    assertEquals("abc", solution.get_value("/a/b/c"));
  }

}
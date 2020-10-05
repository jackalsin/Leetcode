package _0201_0250._208_Implement_Trie;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/7/2017.
 */
class TrieTest {
  private Trie trie;

  @BeforeEach
  void setUp() throws Exception {
    trie = new Trie();
  }

  @Test
  void testInsert() throws Exception {
    trie.insert("a");
    trie.insert("abc");
    trie.insert("abcd");
    trie.insert("abdd");
    trie.insert("dbcd");

  }

  @Test
  void testSearch() throws Exception {
    testInsert();
    assertTrue(trie.search("a"));
    assertTrue(trie.search("abc"));
    assertTrue(trie.search("abcd"));
    assertTrue(trie.search("dbcd"));
    assertFalse(trie.search("aw"));
    assertFalse(trie.search("abce"));
    assertTrue(trie.search("abdd"));
  }

  @Test
  void testStartWith() throws Exception {
    testInsert();
    assertTrue(trie.startsWith("a"));
    assertTrue(trie.startsWith("ab"));
    assertTrue(trie.startsWith("abc"));
    assertTrue(trie.startsWith("abcd"));
    assertFalse(trie.startsWith("abcde"));
    assertTrue(trie.startsWith("db"));
    assertFalse(trie.startsWith("dc"));
  }

  @Test
  void testEmpty() throws Exception {
    assertFalse(trie.startsWith("a"));
    assertFalse(trie.search("a"));
  }
}

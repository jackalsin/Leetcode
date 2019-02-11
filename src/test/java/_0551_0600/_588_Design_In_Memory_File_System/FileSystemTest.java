package _0551_0600._588_Design_In_Memory_File_System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
class FileSystemTest {
  private FileSystem solution;

  @BeforeEach
  void setUp() {
    solution = new FileSystem();
  }

  @Test
  void testOnlineCase1() {
//  ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//  [[],          ["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
//[null,[],null,null,["a"],"hello"]
    assertEquals(new ArrayList<>(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    solution.addContentToFile("/a/b/c/d", "hello");
    assertEquals(List.of("a"), solution.ls("/"));
    assertEquals("hello", solution.readContentFromFile("/a/b/c/d"));
  }

  @Test
  void testOnlineCase2() {
//    ["FileSystem","ls","mkdir","ls"]
//    [[],["/"],["/a/b/c"],["/a/b"]]
    assertEquals(new ArrayList<>(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    assertEquals(List.of("c"), solution.ls("/a/b"));
  }

  @Test
  void testOnlineCase3() {
//["mkdir",       "ls",       "ls", "mkdir","ls","ls","addContentToFile",         "ls","ls",        "ls"]
//[["/goowmfn"],["/goowmfn"],["/"],["/z"],["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]
    solution.mkdir("/goowmfn");
    assertEquals(List.of(), solution.ls("/goowmfn"));
    assertEquals(List.of("goowmfn"), solution.ls("/"));
    solution.mkdir("/z");
    assertEquals(List.of("goowmfn", "z"), solution.ls("/"));
    assertEquals(List.of("goowmfn", "z"), solution.ls("/"));
    solution.addContentToFile("/goowmfn/c", "shetopcy");
    assertEquals(List.of("c"), solution.ls("/goowmfn/c"));
    assertEquals(List.of("c"), solution.ls("/goowmfn"));
  }

  @Test
  void testOnlineCase4() {
    //["FileSystem","ls","mkdir",     "ls",     "mkdir",   "ls"]
    //[[],          ["/"],["/a/b/c"], ["/a/b"], ["/a/b/a"],["/a/b"]]
    //[null,        [],   null,       ["c"],    null,      ["a","c"]]
    assertEquals(List.of(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    assertEquals(List.of("c"), solution.ls("/a/b"));
    solution.mkdir("/a/b/a");
    assertEquals(List.of("a", "c"), solution.ls("/a/b"));
  }

  @Test
  void testOnlineCase5() {
    //["mkdir",     "ls",         "ls",      "mkdir", "ls",           "ls",           "addContentToFile",        "ls",  "ls",           "ls"]
    //[["/goowmfn"],["/goowmfn"], ["/"],     ["/z"],  ["/"],          ["/"],          ["/goowmfn/c","shetopcy"],["/z"], ["/goowmfn/c"], ["/goowmfn"]]
    //[null,        [],           ["goowmfn"],null,   ["goowmfn","z"],["goowmfn","z"],null,                     [],     ["c"],          ["c"]]
    solution.mkdir("/goowmfn");
    assertEquals(List.of(), solution.ls("/goowmfn"));
    assertEquals(List.of("goowmfn"), solution.ls("/"));
    solution.mkdir("/z");
    assertEquals(List.of("goowmfn", "z"), solution.ls("/"));
    assertEquals(List.of("goowmfn", "z"), solution.ls("/"));
    solution.addContentToFile("/goowmfn/c", "shetopcy");
    assertEquals(List.of(), solution.ls("/z"));
    assertEquals(List.of("c"), solution.ls("/goowmfn/c"));
    assertEquals(List.of("c"), solution.ls("/goowmfn"));
  }

}
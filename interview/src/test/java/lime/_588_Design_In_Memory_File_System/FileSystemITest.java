package lime._588_Design_In_Memory_File_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class FileSystemITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(FileSystem solution) {
//  ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
//  [[],          ["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
//[null,[],null,null,["a"],"hello"]
    assertEquals(new ArrayList<>(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    solution.addContentToFile("/a/b/c/d", "hello");
    assertEquals(List.of("a"), solution.ls("/"));
    assertEquals("hello", solution.readContentFromFile("/a/b/c/d"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(FileSystem solution) {
//    ["FileSystem","ls","mkdir","ls"]
//    [[],["/"],["/a/b/c"],["/a/b"]]
    assertEquals(new ArrayList<>(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    assertEquals(List.of("c"), solution.ls("/a/b"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(FileSystem solution) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(FileSystem solution) {
    //["FileSystem","ls","mkdir",     "ls",     "mkdir",   "ls"]
    //[[],          ["/"],["/a/b/c"], ["/a/b"], ["/a/b/a"],["/a/b"]]
    //[null,        [],   null,       ["c"],    null,      ["a","c"]]
    assertEquals(List.of(), solution.ls("/"));
    solution.mkdir("/a/b/c");
    assertEquals(List.of("c"), solution.ls("/a/b"));
    solution.mkdir("/a/b/a");
    assertEquals(List.of("a", "c"), solution.ls("/a/b"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(FileSystem solution) {
    //["mkdir",     "ls",         "ls",      "mkdir", "ls",           "ls",           "addContentToFile",
    // "ls",  "ls",           "ls"]
    //[["/goowmfn"],["/goowmfn"], ["/"],     ["/z"],  ["/"],          ["/"],          ["/goowmfn/c","shetopcy"],
    // ["/z"], ["/goowmfn/c"], ["/goowmfn"]]
    //[null,        [],           ["goowmfn"],null,   ["goowmfn","z"],["goowmfn","z"],null,                     [],
    // ["c"],          ["c"]]
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

  static Stream<FileSystem> solutionStream() {
    return Stream.of(
        new FileSystemI()
    );
  }
}
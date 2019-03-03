package interviews.airbnb._588_Design_In_Memory_File_System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/2/2019.
 */
public final class FileSystem {
  private final Node root = new Node();

  public List<String> ls(String path) {
    final List<String> result = new ArrayList<>();
    final String[] paths = path.split("/");
    if (paths.length == 0) {
      result.addAll(root.subNode.keySet());
      Collections.sort(result);
    }
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      cur = cur.subNode.get(paths[i]);
      if (cur == null) {
        return result;
      }
      if (i == paths.length - 1) {
        if (cur.isFolder) {
          result.addAll(cur.subNode.keySet());
          Collections.sort(result);
        } else {
          result.add(paths[i]);
        }
      }
    }
    return result;
  }

  public void mkdir(String path) {
    Node cur = root;
    final String[] paths = path.split("/");
    for (int i = 1; i < paths.length; i++) {
      cur.subNode.putIfAbsent(paths[i], new Node());
      cur = cur.subNode.get(paths[i]);
    }
  }

  public void addContentToFile(String filePath, String content) {
    Node cur = root;
    final String[] paths = filePath.split("/");
    for (int i = 1; i < paths.length; i++) {
      cur.subNode.putIfAbsent(paths[i], new Node());
      cur = cur.subNode.get(paths[i]);
    }
    cur.isFolder = false;
    cur.content.append(content);
  }

  public String readContentFromFile(String filePath) {
    Node cur = root;
    final String[] paths = filePath.split("/");
    for (int i = 1; i < paths.length; i++) {
      cur.subNode.putIfAbsent(paths[i], new Node());
      cur = cur.subNode.get(paths[i]);
    }
    return cur.content.toString();
  }

  private static final class Node {
    private final StringBuilder content = new StringBuilder();
    private final Map<String, Node> subNode = new HashMap<>();
    private boolean isFolder = true;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString("a//b/bb////".split("/")));
  }
}

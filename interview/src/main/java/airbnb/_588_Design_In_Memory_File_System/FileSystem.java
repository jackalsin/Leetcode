package airbnb._588_Design_In_Memory_File_System;

import java.util.ArrayList;
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
    final String[] paths = path.split("/");
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      if (!cur.children.containsKey(paths[i])) {
        cur.children.put(paths[i], new Node());
      }
      cur = cur.children.get(paths[i]);
    }
    if (cur.isFolder) {
      final List<String> result = new ArrayList<>(cur.children.keySet());
      Collections.sort(result);
      return result;
    } else {
      return Collections.singletonList(paths[paths.length - 1]);
    }
  }

  public void mkdir(String path) {
    final String[] paths = path.split("/");
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      if (!cur.children.containsKey(paths[i])) {
        cur.children.put(paths[i], new Node());
      }
      cur = cur.children.get(paths[i]);
    }
  }

  public void addContentToFile(String filePath, String content) {
    final String[] paths = filePath.split("/");
    Node cur = root;
    for (int i = 1; i < paths.length - 1; i++) {
      cur = cur.children.get(paths[i]);
    }

    // create file if absent
    cur.children.putIfAbsent(paths[paths.length - 1], new Node(false));
    cur = cur.children.get(paths[paths.length - 1]);
    cur.content.append(content);
  }


  public String readContentFromFile(String filePath) {
    final String[] paths = filePath.split("/");
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      cur = cur.children.get(paths[i]);
    }
    assert !cur.isFolder;
    return cur.content.toString();
  }

  private static final class Node {
    private boolean isFolder = true;
    private final Map<String, Node> children = new HashMap<>();
    private final StringBuilder content = new StringBuilder();

    private Node() {
    }

    private Node(boolean isFolder) {
      this.isFolder = isFolder;
    }
  }
}

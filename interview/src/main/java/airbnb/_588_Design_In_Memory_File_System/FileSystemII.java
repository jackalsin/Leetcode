package airbnb._588_Design_In_Memory_File_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 8/30/2021
 */
public final class FileSystemII implements FileSystem {
  private static final String DELIMITER = "/";
  private final Node root = new Node();

  public List<String> ls(String path) {
    final String[] paths = path.split(DELIMITER);
    Node cur = root;
    for (int i = 1; i < paths.length; ++i) {
      if (cur.children.containsKey(paths[i])) {
        cur = cur.children.get(paths[i]);
      } else {
        return Collections.emptyList();
      }
    }

    return cur.isFile() ?
        Collections.singletonList(paths[paths.length - 1])
        : new ArrayList<>(cur.children.keySet());
  }

  public void mkdir(String path) {
    final String[] paths = path.split(DELIMITER);
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      cur = cur.children.computeIfAbsent(p, k -> new Node());
    }
  }

  public void addContentToFile(String filePath, String content) {
    Node cur = root;
    final String[] paths = filePath.split(DELIMITER);
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      cur = cur.children.computeIfAbsent(p, k -> new Node());
    }
    if (cur.content == null) cur.content = new StringBuilder();
    cur.content.append(content);
  }

  public String readContentFromFile(String filePath) {
    Node cur = root;
    final String[] paths = filePath.split(DELIMITER);
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      cur = cur.children.computeIfAbsent(p, k -> new Node());
    }
    return cur.content.toString();
  }

  private static final class Node {
    private StringBuilder content;
    private final TreeMap<String, Node> children = new TreeMap<>();

    private boolean isFile() {
      return content != null;
    }
  }
}

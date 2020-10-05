package _0551_0600._588_Design_In_Memory_File_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public final class MapSolution implements FileSystem {
  private final File root = new File();

  public List<String> ls(String path) {
    final String[] paths = path.split("/");
    File cur = root;
    final List<String> result = new ArrayList<>();
    for (int i = 1; i < paths.length; i++) {
      cur = cur.children.get(paths[i]);
      if (cur == null) {
        return result;
      }
    }
    if (cur.isFile) {
      result.add(paths[paths.length - 1]);
      return result;
    } else {
      result.addAll(cur.children.keySet());
      Collections.sort(result);
      return result;
    }
  }

  public void mkdir(String path) {
    final String[] paths = path.split("/");
    File cur = root;

    for (int i = 1; i < paths.length; i++) {
      cur.children.putIfAbsent(paths[i], new File());
      cur = cur.children.get(paths[i]);
    }
  }

  public void addContentToFile(String path, String content) {
    final String[] paths = path.split("/");
    File cur = root;
    for (int i = 1; i < paths.length; i++) {
      cur.children.putIfAbsent(paths[i], new File());
      cur = cur.children.get(paths[i]);
    }
    cur.isFile = true;
    cur.content.append(content);
  }

  public String readContentFromFile(String path) {
    final String[] paths = path.split("/");
    File cur = root;
    for (int i = 1; i < paths.length; i++) {
      cur = cur.children.get(paths[i]);
    }
    return cur.content.toString();
  }

  private final class File {
    private boolean isFile = false;
    private Map<String, File> children = new HashMap<>();
    private StringBuilder content = new StringBuilder();
  }
}

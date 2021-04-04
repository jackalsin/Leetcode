package lime._588_Design_In_Memory_File_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class FileSystemI implements FileSystem {
  private static final String SLASH = "/";
  private final File root = new File(false);

  public List<String> ls(String path) {
    final String[] items = getPath(path);
    final int n = items.length;
    File cur = root;
    for (int i = 1; i < n; ++i) {
      cur = cur.children.get(items[i]);
      if (cur == null) {
        return Collections.emptyList();
      }
    }
    if (cur.isFile) {
      return List.of(items[n - 1]);
    } else {
      final List<String> result = new ArrayList<>(cur.children.keySet());
      Collections.sort(result);
      return result;
    }
  }

  public void mkdir(String path) {
    final String[] items = getPath(path);
    final int n = items.length;
    File cur = root;
    for (int i = 1; i < n; ++i) {
      cur.children.putIfAbsent(items[i], new File(false));
      cur = cur.children.get(items[i]);
    }
  }

  public void addContentToFile(String filePath, String content) {
    final String[] items = getPath(filePath);
    final int n = items.length;
    File cur = root;
    for (int i = 1; i < n; ++i) {
      cur.children.putIfAbsent(items[i], new File(i == n - 1));
      cur = cur.children.get(items[i]);
    }
    cur.content.append(content);
  }

  public String readContentFromFile(String filePath) {
    final String[] items = getPath(filePath);
    final int n = items.length;
    File cur = root;
    for (int i = 1; i < n; ++i) {
      cur = cur.children.get(items[i]);
    }
    return cur.content.toString();
  }

  private static String[] getPath(final String path) {
    return path.split(SLASH);
  }

  private static final class File {
    private final Map<String, File> children = new HashMap<>();
    private final StringBuilder content = new StringBuilder();
    private final boolean isFile;

    private File(final boolean isFile) {
      this.isFile = isFile;
    }
  }

}

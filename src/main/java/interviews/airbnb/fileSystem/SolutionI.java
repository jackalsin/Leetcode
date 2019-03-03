package interviews.airbnb.fileSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/2/2019.
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();

  public void create(String path, String value) {
    if (path == null) {
      throw new NullPointerException();
    }
    final String[] paths = path.split("/");
    if (paths.length == 0) {
      return; // path == "/"
    }
    Node cur = root;
    if (root.runnable != null) {
      root.runnable.run();
    }
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      if (i == paths.length - 1) {
        cur.subNodes.put(p, new Node());
      }
      cur = cur.subNodes.get(p);
      if (cur == null) {
        return;
      }
      if (cur.runnable != null) {
        cur.runnable.run();
      }
    }
    cur.content = value;
  }

  public boolean set_value(String path, String value) {
    if (path == null) {
      throw new NullPointerException();
    }
    final String[] paths = path.split("/");
    if (paths.length == 0) {
      root.content = value;
      return true; // path == "/"
    }
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      cur = cur.subNodes.get(p);
      if (cur == null) {
        return false;
      }
    }
    cur.content = value;
    return true;
  }

  public String get_value(String path) {
    if (path == null) {
      throw new NullPointerException();
    }
    final String[] paths = path.split("/");
    if (paths.length == 0) {
      return root.content; // path == "/"
    }
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      final String p = paths[i];
      cur = cur.subNodes.get(p);
      if (cur == null) {
        return null;
      }
    }
    return cur.content;
  }

  public void watch(String path, Runnable runnable) {
    if (path == null) {
      throw new NullPointerException();
    }
    final String[] paths = path.split("/");
    if (paths.length == 0) {
      root.runnable = runnable;
      return; // path == "/"
    }
    Node cur = root;
    for (int i = 1; i < paths.length; i++) {
      cur = cur.subNodes.get(paths[i]);
      if (cur == null) {
        return;
      }
    }
    cur.runnable = runnable;
  }

  private static final class Node {
    private final Map<String, Node> subNodes = new HashMap<>();
    private Runnable runnable = null;
    private String content = null;
  }

}

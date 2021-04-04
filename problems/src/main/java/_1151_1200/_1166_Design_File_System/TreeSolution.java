package _1151_1200._1166_Design_File_System;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class TreeSolution implements FileSystem {
  private final File root = new File(-1);

  public boolean createPath(String path, int value) {
    if (path.isEmpty() || !path.startsWith("/")) {
      return false;
    }
    final String[] items = path.split("/");
//    System.out.println(Arrays.toString(items));
    return createPath(root, items, 1, value);
  }

  private static boolean createPath(final File root, final String[] paths,
                                    final int i, final int val) {
    if (i == paths.length - 1) {
      return root.map.putIfAbsent(paths[i], new File(val)) == null;
    }
    if (!root.map.containsKey(paths[i])) {
      return false;
    }
    root.map.putIfAbsent(paths[i], new File(val));
    return createPath(root.map.get(paths[i]), paths, i + 1, val);
  }

  public int get(String path) {
    final String[] items = path.split("/");
    return get(root, items, 1);
  }

  private int get(final File root, final String[] path, final int i) {
    if (root == null) {
      return -1;
    }
    if (i == path.length) {
      return root.val;
    }
    return get(root.map.get(path[i]), path, i + 1);
  }

  private static final class File {
    private final int val;
    private final Map<String, File> map = new HashMap<>();

    private File(final int val) {
      this.val = val;
    }

  }
}

package _1151_1200._1166_Design_File_System;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public final class OneMapSolution implements FileSystem {
  private final Map<String, Integer> map = new HashMap<>() {{
    put("", -1);
  }};

  public boolean createPath(String path, int value) {
    final int lastIndexOfSlash = path.lastIndexOf("/");
    final String parent = path.substring(0, lastIndexOfSlash);
    if (!map.containsKey(parent)) {
      return false;
    }
    return map.putIfAbsent(path, value) == null;
  }

  public int get(String path) {
    return map.getOrDefault(path, -1);
  }
}

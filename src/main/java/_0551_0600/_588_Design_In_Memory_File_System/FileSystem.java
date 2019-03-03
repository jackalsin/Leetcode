package _0551_0600._588_Design_In_Memory_File_System;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public interface FileSystem {

  List<String> ls(String path);

  void mkdir(String path);

  void addContentToFile(String path, String content);

  String readContentFromFile(String path);

}

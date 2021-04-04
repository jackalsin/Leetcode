package lime._588_Design_In_Memory_File_System;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
public interface FileSystem {
   List<String> ls(String path);

   void mkdir(String path);

   void addContentToFile(String filePath, String content);

   String readContentFromFile(String filePath);
}

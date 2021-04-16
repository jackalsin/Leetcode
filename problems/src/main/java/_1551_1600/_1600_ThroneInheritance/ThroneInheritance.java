package _1551_1600._1600_ThroneInheritance;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/15
 */
public interface ThroneInheritance {
   void birth(String parentName, String childName);

   void death(String name);

   List<String> getInheritanceOrder();
}

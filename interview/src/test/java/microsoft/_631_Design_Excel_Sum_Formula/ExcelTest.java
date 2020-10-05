package microsoft._631_Design_Excel_Sum_Formula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelTest {

  @Test
  void testOnlineCase() throws Exception {
    final Excel excel = new Excel(3, 'C');
    excel.set(1, 'A', 2);
    assertEquals(4, excel.sum(3, 'C', new String[]{"A1", "A1:B2"}));
    excel.set(2, 'B', 2);
    assertEquals(6, excel.get(3, 'C'));
  }

  @Test
  void testFailedCaseDuplicatedSumElement() throws Exception {
    final Excel excel = new Excel(5, 'E');
    assertEquals(0, excel.get(1, 'A'));
    excel.set(1, 'A', 1);
    assertEquals(1, excel.get(1, 'A'));
    assertEquals(2, excel.sum(2, 'B', new String[]{"A1", "A1"}));
    excel.set(1, 'A', 2);
    assertEquals(4, excel.get(2, 'B'));
  }

  /**
   * The sum cell can also be a regular cell referenced to others
   *
   * @throws Exception
   */
  @Test
  void testFailedCase2() throws Exception {
//    ["get",  "set",    "get",  "sum",              "set",    "get",  "sum","set","get"]
//    [[1,"A"],[1,"A",1],[1,"A"],[2,"B",["A1","A1"]],[1,"A",2],[2,"B"],[3,"C",["B2","A1:B2"]],[2,"B",0],[3,"C"]]
//    [0,      null,     1,      2,                   null,    4,                    10,null,2]
    final Excel excel = new Excel(5, 'E');
    assertEquals(0, excel.get(1, 'A'));
    excel.set(1, 'A', 1);
    assertEquals(1, excel.get(1, 'A'));
    assertEquals(2, excel.sum(2, 'B', new String[]{"A1", "A1"}));
    excel.set(1, 'A', 2);
    assertEquals(4, excel.get(2, 'B'));
    assertEquals(10, excel.sum(3, 'C', new String[]{"B2", "A1:B2"}));
    excel.set(2, 'B', 0);
    assertEquals(2, excel.get(3, 'C'));
  }

  /**
   * Need recursive find the sum cell, check line 47
   *
   * @throws Exception
   */
  @Test
  void testFailedCase3() throws Exception {
//["Excel","set",   "set",     "set",    "sum",                 "get",  "set",    "get",  "sum",            "set",    "get",    "get",  "sum",                    "set",   "get",   "get",  "get","get"]
//[[5,"E"],[1,"A",5],[1,"B",3],[1,"C",2],[1,"C",["A1","A1:B1"]],[1,"C"],[1,"B",5],[1,"C"],[1,"B",["A1:A5"]],[5,"A",10],[1,"B"],[1,"C"],[3,"C",["A1:C1","A1:A5"]],[3,"A",3],[1,"B"],[1,"C"],[3,"C"],[5,"A"]]
//[null,   null,     null,     null,      13,                   13,     null,     15,       5,               null,     15,      25,     60,                       null,    18,     28,     69,     10]
    final Excel excel = new Excel(5, 'E');
    excel.set(1, 'A', 5);
    excel.set(1, 'B', 3);
    excel.set(1, 'C', 2);
    assertEquals(13, excel.sum(1, 'C', new String[]{"A1", "A1:B1"}));
    assertEquals(13, excel.get(1, 'C'));
    excel.set(1, 'B', 5);
    assertEquals(15, excel.get(1, 'C'));
    assertEquals(5, excel.sum(1, 'B', new String[]{"A1:A5"}));
    excel.set(5, 'A', 10);
    assertEquals(15, excel.get(1, 'B'));
    assertEquals(25, excel.get(1, 'C')); // failed here
    assertEquals(60, excel.sum(3, 'C', new String[]{"A1:C1", "A1:A5"}));
    excel.set(3, 'A', 3);
    assertEquals(18, excel.get(1, 'B'));
    assertEquals(28, excel.get(1, 'C'));
    assertEquals(69, excel.get(3, 'C'));
    assertEquals(10, excel.get(5, 'A'));

  }

  @Test
  void testFailedCase4() throws Exception {
//    ["Excel","sum","set","get"]
//    [[3,"C"],[1,"A",["A2"]],[2,"A",1],[1,"A"]]
    final Excel excel = new Excel(3, 'C');
    assertEquals(0, excel.sum(1, 'A', new String[]{"A2"}));
    excel.set(2, 'A', 1);
    assertEquals(1, excel.get(1, 'A'));
  }
}